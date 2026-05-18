package com.nammakelsa.ui.worker

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.GeoPoint
import com.nammakelsa.data.model.ProfileFormState
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.data.model.ValidationResult
import com.nammakelsa.domain.repository.LocationRepository
import com.nammakelsa.domain.repository.StorageRepository
import com.nammakelsa.domain.repository.WorkerRepository
import com.nammakelsa.util.GeoHashUtil
import com.nammakelsa.util.WorkerProfileValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkerProfileViewModel @Inject constructor(
    private val workerRepository: WorkerRepository,
    private val storageRepository: StorageRepository,
    private val locationRepository: LocationRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _formState = MutableStateFlow(ProfileFormState())
    val formState: StateFlow<ProfileFormState> = _formState.asStateFlow()

    private val _saveState = MutableStateFlow<UiResult<Unit>?>(null)
    val saveState: StateFlow<UiResult<Unit>?> = _saveState.asStateFlow()

    private val _galleryState = MutableStateFlow<List<String>>(emptyList())
    val galleryState: StateFlow<List<String>> = _galleryState.asStateFlow()

    private val _confirmationEvent = MutableSharedFlow<String>(extraBufferCapacity = 1)
    val confirmationEvent: SharedFlow<String> = _confirmationEvent.asSharedFlow()

    private val uid: String get() = firebaseAuth.currentUser?.uid ?: ""

    init {
        loadProfile()
    }

    private fun loadProfile() {
        val currentUid = uid
        if (currentUid.isBlank()) return

        viewModelScope.launch {
            val result = workerRepository.getProfile(currentUid)
            result.onSuccess { profile ->
                _formState.value = ProfileFormState(
                    name = profile.name,
                    skillType = profile.skillType,
                    dailyRateInr = profile.dailyRateInr.toString(),
                    profilePhotoUri = null
                )
                _galleryState.value = profile.galleryPhotoUrls
            }
        }
    }

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

    fun onSave() {
        val currentForm = _formState.value
        val validationResult = WorkerProfileValidator.validate(currentForm, isRegistration = false)

        if (validationResult is ValidationResult.Invalid) {
            val errors = validationResult.errors.associateBy { it.field }
            _formState.update { form ->
                form.copy(
                    nameError = errors["name"]?.message,
                    skillError = errors["skillType"]?.message,
                    rateError = errors["dailyRateInr"]?.message
                )
            }
            return
        }

        viewModelScope.launch {
            _saveState.value = UiResult.Loading

            val currentUid = uid
            if (currentUid.isBlank()) {
                _saveState.value = UiResult.Error("User not authenticated")
                return@launch
            }

            val updates = mutableMapOf<String, Any>()
            updates["name"] = currentForm.name.trim()
            updates["skillType"] = currentForm.skillType!!.name
            updates["dailyRateInr"] = currentForm.dailyRateInr.trim().toInt()

            val newPhotoUri = currentForm.profilePhotoUri
            if (newPhotoUri != null) {
                val uploadResult = storageRepository.uploadImage(
                    "profile-photos/$currentUid/profile.jpg",
                    newPhotoUri
                )
                uploadResult.onSuccess { url -> updates["profilePhotoUrl"] = url }
                uploadResult.onFailure {
                    _saveState.value = UiResult.Error("Failed to upload photo: ${it.message}")
                    return@launch
                }
            }

            val locationResult = locationRepository.getCurrentLocation()
            locationResult.onSuccess { latLng ->
                updates["location"] = GeoPoint(latLng.latitude, latLng.longitude)
                updates["geoHash"] = GeoHashUtil.encode(latLng.latitude, latLng.longitude)
            }

            val saveResult = workerRepository.updateProfile(currentUid, updates)
            _saveState.value = saveResult.fold(
                onSuccess = {
                    _confirmationEvent.tryEmit("Profile updated successfully")
                    UiResult.Success(Unit)
                },
                onFailure = { e ->
                    UiResult.Error(e.message ?: "Failed to save profile")
                }
            )
        }
    }

    fun addGalleryPhoto(uri: Uri) {
        val currentUid = uid
        if (currentUid.isBlank()) return

        viewModelScope.launch {
            val result = workerRepository.addGalleryPhoto(currentUid, uri)
            result.onSuccess { url ->
                _galleryState.update { it + url }
            }
            result.onFailure { e ->
                _confirmationEvent.tryEmit("Failed to add photo: ${e.message}")
            }
        }
    }

    fun deleteGalleryPhoto(url: String) {
        val currentUid = uid
        if (currentUid.isBlank()) return

        viewModelScope.launch {
            val result = workerRepository.deleteGalleryPhoto(currentUid, url)
            result.onSuccess {
                _galleryState.update { it.filter { photoUrl -> photoUrl != url } }
            }
            result.onFailure { e ->
                _confirmationEvent.tryEmit("Failed to delete photo: ${e.message}")
            }
        }
    }
}
