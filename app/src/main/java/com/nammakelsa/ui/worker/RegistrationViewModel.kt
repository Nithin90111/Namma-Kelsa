package com.nammakelsa.ui.worker

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.GeoPoint
import com.nammakelsa.data.model.ProfileFormState
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.data.model.ValidationResult
import com.nammakelsa.data.model.WorkerProfile
import com.nammakelsa.domain.repository.LocationRepository
import com.nammakelsa.domain.repository.StorageRepository
import com.nammakelsa.domain.repository.WorkerRepository
import com.nammakelsa.util.GeoHashUtil
import com.nammakelsa.util.WorkerProfileValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val workerRepository: WorkerRepository,
    private val storageRepository: StorageRepository,
    private val locationRepository: LocationRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _formState = MutableStateFlow(ProfileFormState())
    val formState: StateFlow<ProfileFormState> = _formState.asStateFlow()

    private val _registrationState = MutableStateFlow<UiResult<Unit>?>(null)
    val registrationState: StateFlow<UiResult<Unit>?> = _registrationState.asStateFlow()

    fun updateName(name: String) {
        _formState.update { it.copy(name = name, nameError = null) }
    }

    fun updateSkillType(skill: SkillType) {
        _formState.update { it.copy(skillType = skill, skillError = null) }
    }

    fun updateDailyRate(rate: String) {
        _formState.update { it.copy(dailyRateInr = rate, rateError = null) }
    }

    fun updateProfilePhotoUri(uri: Uri) {
        _formState.update { it.copy(profilePhotoUri = uri, photoError = null) }
    }

    fun onSubmit() {
        val currentForm = _formState.value
        val validationResult = WorkerProfileValidator.validate(currentForm, isRegistration = true)

        if (validationResult is ValidationResult.Invalid) {
            val errors = validationResult.errors.associateBy { it.field }
            _formState.update { form ->
                form.copy(
                    nameError = errors["name"]?.message,
                    skillError = errors["skillType"]?.message,
                    rateError = errors["dailyRateInr"]?.message,
                    photoError = errors["profilePhotoUri"]?.message
                )
            }
            return
        }

        viewModelScope.launch {
            _registrationState.value = UiResult.Loading

            val uid = firebaseAuth.currentUser?.uid
            if (uid == null) {
                _registrationState.value = UiResult.Error("User not authenticated. Please sign in again.")
                return@launch
            }

            // Get current GPS location
            val locationResult = locationRepository.getCurrentLocation()
            val latLng = locationResult.getOrElse {
                _registrationState.value = UiResult.Error("Could not get location: ${it.message}")
                return@launch
            }

            // Upload profile photo
            val photoUri = currentForm.profilePhotoUri!!
            val uploadResult = storageRepository.uploadImage("profile-photos/$uid/profile.jpg", photoUri)
            val photoUrl = uploadResult.getOrElse {
                _registrationState.value = UiResult.Error("Failed to upload photo: ${it.message}")
                return@launch
            }

            // Build and save the worker profile
            val profile = WorkerProfile(
                uid = uid,
                name = currentForm.name.trim(),
                phoneNumber = firebaseAuth.currentUser?.phoneNumber ?: "",
                skillType = currentForm.skillType!!,
                dailyRateInr = currentForm.dailyRateInr.trim().toInt(),
                location = GeoPoint(latLng.latitude, latLng.longitude),
                geoHash = GeoHashUtil.encode(latLng.latitude, latLng.longitude),
                profilePhotoUrl = photoUrl,
                galleryPhotoUrls = emptyList(),
                isAvailable = false,
                createdAt = Timestamp.now(),
                updatedAt = Timestamp.now()
            )

            val createResult = workerRepository.createProfile(profile)
            _registrationState.value = createResult.fold(
                onSuccess = { UiResult.Success(Unit) },
                onFailure = { e -> UiResult.Error(e.message ?: "Failed to create profile") }
            )
        }
    }
}
