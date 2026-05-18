package com.nammakelsa.ui.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.data.model.WorkerProfile
import com.nammakelsa.domain.repository.WorkerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkerProfileViewViewModel @Inject constructor(
    private val workerRepository: WorkerRepository
) : ViewModel() {

    private val _profileState = MutableStateFlow<UiResult<WorkerProfile>>(UiResult.Loading)
    val profileState: StateFlow<UiResult<WorkerProfile>> = _profileState.asStateFlow()

    private val _dialerEvent = MutableSharedFlow<String>(extraBufferCapacity = 1)
    val dialerEvent: SharedFlow<String> = _dialerEvent.asSharedFlow()

    fun loadProfile(workerId: String) {
        viewModelScope.launch {
            _profileState.value = UiResult.Loading
            val result = workerRepository.getProfile(workerId)
            _profileState.value = result.fold(
                onSuccess = { profile -> UiResult.Success(profile) },
                onFailure = { e -> UiResult.Error(e.message ?: "Failed to load worker profile") }
            )
        }
    }

    /**
     * Emits the worker's phone number as a one-shot event.
     * The fragment observes this and fires an ACTION_DIAL intent.
     *
     * Property 11: Call button launches dialer with correct phone number.
     * Validates: Requirements 5.3
     */
    fun onCallClicked(phoneNumber: String) {
        _dialerEvent.tryEmit(phoneNumber)
    }
}
