package com.nammakelsa.domain.repository

import android.app.Activity
import com.google.firebase.auth.FirebaseUser

/**
 * Abstraction over Firebase Authentication for phone-number OTP sign-in.
 */
interface AuthRepository {

    /**
     * Initiates phone number verification and sends an OTP to [phoneNumber].
     *
     * [activity] is required by the Firebase Phone Auth SDK to bind the verification
     * flow to the calling Activity's lifecycle (for reCAPTCHA and auto-verification).
     *
     * @return [Result.success] containing the verificationId on success, or
     *         "AUTO_VERIFIED" when the SIM card auto-verifies the number, or
     *         [Result.failure] with the underlying exception on failure.
     */
    suspend fun sendOtp(phoneNumber: String, activity: Activity): Result<String>

    /**
     * Verifies the OTP entered by the user and signs them in.
     *
     * @param verificationId The ID returned by [sendOtp].
     * @param otp            The 6-digit code entered by the user.
     * @return [Result.success] with the authenticated [FirebaseUser], or
     *         [Result.failure] on invalid OTP or network error.
     */
    suspend fun verifyOtp(verificationId: String, otp: String): Result<FirebaseUser>

    /** Returns the currently signed-in [FirebaseUser], or null if not authenticated. */
    fun currentUser(): FirebaseUser?

    /** Signs out the current user and clears the persisted session. */
    suspend fun signOut()

    /**
     * Returns true if [user] is signing in for the first time (new user),
     * false if they are a returning user.
     */
    fun isNewUser(user: FirebaseUser): Boolean
}
