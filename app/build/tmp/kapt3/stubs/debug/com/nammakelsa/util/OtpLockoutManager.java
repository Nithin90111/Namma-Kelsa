package com.nammakelsa.util;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Manages OTP verification failure tracking and lockout state.
 *
 * After 3 consecutive failed OTP attempts, the user is locked out for 10 minutes.
 * State is persisted in [SharedPreferences] so lockouts survive app restarts.
 *
 * Property 15: OTP lockout applied after 3 consecutive failures.
 * Validates: Requirements 8.5
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/nammakelsa/util/OtpLockoutManager;", "", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getFailureCount", "", "isLocked", "", "recordFailure", "", "remainingLockoutMs", "", "reset", "Companion", "app_debug"})
public final class OtpLockoutManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_FAILURE_COUNT = "otp_failure_count";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LOCKOUT_UNTIL_MS = "otp_lockout_until_ms";
    private static final int MAX_FAILURES = 3;
    private static final long LOCKOUT_DURATION_MS = 600000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.nammakelsa.util.OtpLockoutManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public OtpLockoutManager(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        super();
    }
    
    /**
     * Records a failed OTP attempt. When the failure count reaches [MAX_FAILURES],
     * sets a 10-minute lockout.
     */
    public final void recordFailure() {
    }
    
    /**
     * Returns true if the user is currently locked out (within the 10-minute window).
     */
    public final boolean isLocked() {
        return false;
    }
    
    /**
     * Returns the number of milliseconds remaining in the current lockout,
     * or 0 if not locked.
     */
    public final long remainingLockoutMs() {
        return 0L;
    }
    
    /**
     * Resets the failure count and lockout state. Call this on successful OTP verification.
     */
    public final void reset() {
    }
    
    /**
     * Returns the current consecutive failure count.
     */
    public final int getFailureCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/nammakelsa/util/OtpLockoutManager$Companion;", "", "()V", "KEY_FAILURE_COUNT", "", "KEY_LOCKOUT_UNTIL_MS", "LOCKOUT_DURATION_MS", "", "MAX_FAILURES", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}