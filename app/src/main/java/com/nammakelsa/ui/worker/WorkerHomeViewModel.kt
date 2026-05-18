package com.nammakelsa.ui.worker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.data.model.WorkerProfile
import com.nammakelsa.domain.repository.WorkerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkerHomeViewModel @Inject constructor(
    private val workerRepository: WorkerRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _profileState = MutableStateFlow<WorkerProfile?>(null)
    val profileState: StateFlow<WorkerProfile?> = _profileState.asStateFlow()

    private val _availabilityState = MutableStateFlow<UiResult<Unit>?>(null)
    val availabilityState: StateFlow<UiResult<Unit>?> = _availabilityState.asStateFlow()

    private val uid: String get() = firebaseAuth.currentUser?.uid ?: ""

    init {
        observeProfile()
    }

    private fun observeProfile() {
        val currentUid = uid
        if (currentUid.isBlank()) return

        viewModelScope.launch {
            workerRepository.observeProfile(currentUid).collect { profile ->
                _profileState.value = profile
            }
        }
    }

    fun setAvailability(available: Boolean) {
        val currentUid = uid
        if (currentUid.isBlank()) {
            _availabilityState.value = UiResult.Error("User not authenticated")
            return
        }

        viewModelScope.launch {
            _availabilityState.value = UiResult.Loading
            val result = workerRepository.setAvailability(currentUid, available)
            _availabilityState.value = result.fold(
                onSuccess = { UiResult.Success(Unit) },
                onFailure = { e -> UiResult.Error(e.message ?: "Failed to update availability") }
            )
        }
    }
}
