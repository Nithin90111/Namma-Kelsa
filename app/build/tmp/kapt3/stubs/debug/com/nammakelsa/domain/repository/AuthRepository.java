package com.nammakelsa.domain.repository;

import android.app.Activity;
import com.google.firebase.auth.FirebaseUser;

/**
 * Abstraction over Firebase Authentication for phone-number OTP sign-in.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/nammakelsa/domain/repository/AuthRepository;", "", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "isNewUser", "", "user", "sendOtp", "Lkotlin/Result;", "", "phoneNumber", "activity", "Landroid/app/Activity;", "sendOtp-0E7RQCE", "(Ljava/lang/String;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOtp", "verificationId", "otp", "verifyOtp-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthRepository {
    
    /**
     * Returns the currently signed-in [FirebaseUser], or null if not authenticated.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract com.google.firebase.auth.FirebaseUser currentUser();
    
    /**
     * Signs out the current user and clears the persisted session.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Returns true if [user] is signing in for the first time (new user),
     * false if they are a returning user.
     */
    public abstract boolean isNewUser(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseUser user);
}