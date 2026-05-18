package com.nammakelsa.data.repository

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.nammakelsa.domain.repository.AuthRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.coroutines.resume

/**
 * Firebase-backed implementation of [AuthRepository].
 *
 * Uses [PhoneAuthProvider] for OTP-based sign-in. The [activity] parameter on
 * [sendOtp] is required by the Firebase SDK to bind the verification flow to the
 * calling Activity's lifecycle (reCAPTCHA fallback and auto-verification).
 */
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    /**
     * Initiates phone number verification via [PhoneAuthProvider.verifyPhoneNumber].
     *
     * Three outcomes are possible:
     * - **Auto-verification** (`onVerificationCompleted`): the SIM card matches the
     *   number; the SDK signs in automatically and this function returns
     *   `Result.success("AUTO_VERIFIED")`.
     * - **Code sent** (`onCodeSent`): returns `Result.success(verificationId)` so the
     *   caller can later pass it to [verifyOtp].
     * - **Failure** (`onVerificationFailed`): returns `Result.failure(exception)`.
     */
    override suspend fun sendOtp(phoneNumber: String, activity: Activity): Result<String> =
        suspendCancellableCoroutine { continuation ->
            val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    // Auto-verification (e.g., SIM card match) — sign in immediately.
                    auth.signInWithCredential(credential)
                        .addOnSuccessListener {
                            if (continuation.isActive) {
                                continuation.resume(Result.success("AUTO_VERIFIED"))
                            }
                        }
                        .addOnFailureListener { e ->
                            if (continuation.isActive) {
                                continuation.resume(Result.failure(e))
                            }
                        }
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    if (continuation.isActive) {
                        continuation.resume(Result.failure(e))
                    }
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    if (continuation.isActive) {
                        continuation.resume(Result.success(verificationId))
                    }
                }
            }

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(callbacks)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)
        }

    /**
     * Verifies the OTP entered by the user and signs them in with Firebase.
     *
     * @param verificationId The ID returned by [sendOtp] (must not be "AUTO_VERIFIED").
     * @param otp            The 6-digit code entered by the user.
     * @return [Result.success] with the authenticated [FirebaseUser], or
     *         [Result.failure] on invalid OTP or network error.
     */
    override suspend fun verifyOtp(verificationId: String, otp: String): Result<FirebaseUser> =
        suspendCancellableCoroutine { continuation ->
            val credential = PhoneAuthProvider.getCredential(verificationId, otp)
            auth.signInWithCredential(credential)
                .addOnSuccessListener { authResult ->
                    val user = authResult.user
                    if (user != null) {
                        continuation.resume(Result.success(user))
                    } else {
                        continuation.resume(
                            Result.failure(Exception("Authentication failed: signed-in user is null"))
                        )
                    }
                }
                .addOnFailureListener { e ->
                    continuation.resume(Result.failure(e))
                }
        }

    /** Returns the currently signed-in [FirebaseUser], or null if not authenticated. */
    override fun currentUser(): FirebaseUser? = auth.currentUser

    /** Signs out the current user and clears the Firebase-persisted session. */
    override suspend fun signOut() {
        auth.signOut()
    }

    /**
     * Returns true if [user] is signing in for the first time.
     *
     * Firebase sets `creationTimestamp == lastSignInTimestamp` for brand-new accounts.
     * If metadata is unavailable (should not happen in practice), defaults to `true`
     * so the user is routed to the registration screen rather than silently skipped.
     */
    override fun isNewUser(user: FirebaseUser): Boolean {
        val metadata = user.metadata ?: return true
        return metadata.creationTimestamp == metadata.lastSignInTimestamp
    }
}
