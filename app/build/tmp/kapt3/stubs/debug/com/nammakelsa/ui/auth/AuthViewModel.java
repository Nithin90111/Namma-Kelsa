package com.nammakelsa.ui.auth;

import android.app.Activity;
import androidx.lifecycle.ViewModel;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.domain.repository.AuthRepository;
import com.nammakelsa.util.OtpLockoutManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/nammakelsa/ui/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/nammakelsa/domain/repository/AuthRepository;", "otpLockoutManager", "Lcom/nammakelsa/util/OtpLockoutManager;", "(Lcom/nammakelsa/domain/repository/AuthRepository;Lcom/nammakelsa/util/OtpLockoutManager;)V", "_lockoutCountdown", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_sendOtpState", "Lcom/nammakelsa/data/model/UiResult;", "", "_verifyOtpState", "", "lockoutCountdown", "Lkotlinx/coroutines/flow/StateFlow;", "getLockoutCountdown", "()Lkotlinx/coroutines/flow/StateFlow;", "sendOtpState", "getSendOtpState", "verifyOtpState", "getVerifyOtpState", "sendOtp", "", "phone", "activity", "Landroid/app/Activity;", "startLockoutCountdown", "verifyOtp", "verificationId", "otp", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.util.OtpLockoutManager otpLockoutManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<java.lang.String>> _sendOtpState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<java.lang.String>> sendOtpState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<java.lang.Boolean>> _verifyOtpState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<java.lang.Boolean>> verifyOtpState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _lockoutCountdown = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> lockoutCountdown = null;
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.util.OtpLockoutManager otpLockoutManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<java.lang.String>> getSendOtpState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<java.lang.Boolean>> getVerifyOtpState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getLockoutCountdown() {
        return null;
    }
    
    public final void sendOtp(@org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void verifyOtp(@org.jetbrains.annotations.NotNull()
    java.lang.String verificationId, @org.jetbrains.annotations.NotNull()
    java.lang.String otp) {
    }
    
    private final void startLockoutCountdown() {
    }
}