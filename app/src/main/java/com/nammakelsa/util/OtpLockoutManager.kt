package com.nammakelsa.util

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages OTP verification failure tracking and lockout state.
 *
 * After 3 consecutive failed OTP attempts, the user is locked out for 10 minutes.
 * State is persisted in [SharedPreferences] so lockouts survive app restarts.
 *
 * Property 15: OTP lockout applied after 3 consecutive failures.
 * Validates: Requirements 8.5
 */
@Singleton
class OtpLockoutManager @Inject constructor(
    private val prefs: SharedPreferences
) {

    companion object {
        private const val KEY_FAILURE_COUNT = "otp_failure_count"
        private const val KEY_LOCKOUT_UNTIL_MS = "otp_lockout_until_ms"
        private const val MAX_FAILURES = 3
        private const val LOCKOUT_DURATION_MS = 10 * 60 * 1000L // 10 minutes
    }

    /**
     * Records a failed OTP attempt. When the failure count reaches [MAX_FAILURES],
     * sets a 10-minute lockout.
     */
    fun recordFailure() {
        val count = getFailureCount() + 1
        prefs.edit().putInt(KEY_FAILURE_COUNT, count).apply()
        if (count >= MAX_FAILURES) {
            val lockoutUntil = System.currentTimeMillis() + LOCKOUT_DURATION_MS
            prefs.edit().putLong(KEY_LOCKOUT_UNTIL_MS, lockoutUntil).apply()
        }
    }

    /**
     * Returns true if the user is currently locked out (within the 10-minute window).
     */
    fun isLocked(): Boolean {
        return System.currentTimeMillis() < prefs.getLong(KEY_LOCKOUT_UNTIL_MS, 0L)
    }

    /**
     * Returns the number of milliseconds remaining in the current lockout,
     * or 0 if not locked.
     */
    fun remainingLockoutMs(): Long {
        val lockoutUntil = prefs.getLong(KEY_LOCKOUT_UNTIL_MS, 0L)
        return maxOf(0L, lockoutUntil - System.currentTimeMillis())
    }

    /**
     * Resets the failure count and lockout state. Call this on successful OTP verification.
     */
    fun reset() {
        prefs.edit()
            .remove(KEY_FAILURE_COUNT)
            .remove(KEY_LOCKOUT_UNTIL_MS)
            .apply()
    }

    /** Returns the current consecutive failure count. */
    fun getFailureCount(): Int = prefs.getInt(KEY_FAILURE_COUNT, 0)
}
