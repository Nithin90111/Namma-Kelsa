package com.nammakelsa.data.repository;

import android.app.Activity;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.nammakelsa.domain.repository.AuthRepository;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/**
 * Firebase-backed implementation of [AuthRepository].
 *
 * Uses [PhoneAuthProvider] for OTP-based sign-in. The [activity] parameter on
 * [sendOtp] is required by the Firebase SDK to bind the verification flow to the
 * calling Activity's lifecycle (reCAPTCHA fallback and auto-verification).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/nammakelsa/data/repository/AuthRepositoryImpl;", "Lcom/nammakelsa/domain/repository/AuthRepository;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "isNewUser", "", "user", "sendOtp", "Lkotlin/Result;", "", "phoneNumber", "activity", "Landroid/app/Activity;", "sendOtp-0E7RQCE", "(Ljava/lang/String;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOtp", "verificationId", "otp", "verifyOtp-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepositoryImpl implements com.nammakelsa.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth) {
        super();
    }
    
    /**
     * Returns the currently signed-in [FirebaseUser], or null if not authenticated.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.google.firebase.auth.FirebaseUser currentUser() {
        return null;
    }
    
    /**
     * Signs out the current user and clears the Firebase-persisted session.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Returns true if [user] is signing in for the first time.
     *
     * Firebase sets `creationTimestamp == lastSignInTimestamp` for brand-new accounts.
     * If metadata is unavailable (should not happen in practice), defaults to `true`
     * so the user is routed to the registration screen rather than silently skipped.
     */
    @java.lang.Override()
    public boolean isNewUser(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseUser user) {
        return false;
    }
}