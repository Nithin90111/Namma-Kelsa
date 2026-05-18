package com.nammakelsa.ui.auth

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.domain.repository.AuthRepository
import com.nammakelsa.util.OtpLockoutManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val otpLockoutManager: OtpLockoutManager
) : ViewModel() {

    private val _sendOtpState = MutableStateFlow<UiResult<String>>(UiResult.Loading)
    val sendOtpState: StateFlow<UiResult<String>> = _sendOtpState.asStateFlow()

    private val _verifyOtpState = MutableStateFlow<UiResult<Boolean>>(UiResult.Loading)
    val verifyOtpState: StateFlow<UiResult<Boolean>> = _verifyOtpState.asStateFlow()

    private val _lockoutCountdown = MutableStateFlow(0L)
    val lockoutCountdown: StateFlow<Long> = _lockoutCountdown.asStateFlow()

    init {
        startLockoutCountdown()
    }

    fun sendOtp(phone: String, activity: Activity) {
        if (phone.isBlank()) {
            _sendOtpState.value = UiResult.Error("Please enter a valid phone number")
            return
        }

        if (otpLockoutManager.isLocked()) {
            val remainingMinutes = (otpLockoutManager.remainingLockoutMs() / 60000) + 1
            _sendOtpState.value = UiResult.Error(
                "Too many failed attempts. Please try again in $remainingMinutes minute(s)."
            )
            return
        }

        viewModelScope.launch {
            _sendOtpState.value = UiResult.Loading
            val result = authRepository.sendOtp(phone, activity)
            _sendOtpState.value = result.fold(
                onSuccess = { verificationId -> UiResult.Success(verificationId) },
                onFailure = { e -> UiResult.Error(e.message ?: "Failed to send OTP") }
            )
        }
    }

    fun verifyOtp(verificationId: String, otp: String) {
        if (otp.isBlank() || otp.length != 6) {
            _verifyOtpState.value = UiResult.Error("Please enter the 6-digit OTP")
            return
        }

        viewModelScope.launch {
            _verifyOtpState.value = UiResult.Loading
            val result = authRepository.verifyOtp(verificationId, otp)
            result.fold(
                onSuccess = { user ->
                    otpLockoutManager.reset()
                    val isNew = authRepository.isNewUser(user)
                    _verifyOtpState.value = UiResult.Success(isNew)
                },
                onFailure = { e ->
                    otpLockoutManager.recordFailure()
                    startLockoutCountdown()
                    _verifyOtpState.value = UiResult.Error(e.message ?: "Invalid OTP. Please try again.")
                }
            )
        }
    }

    private fun startLockoutCountdown() {
        viewModelScope.launch {
            while (otpLockoutManager.isLocked()) {
                _lockoutCountdown.value = otpLockoutManager.remainingLockoutMs()
                delay(1000L)
            }
            _lockoutCountdown.value = 0L
        }
    }
}
