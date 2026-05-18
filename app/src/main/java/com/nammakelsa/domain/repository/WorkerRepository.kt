package com.nammakelsa.domain.repository

import android.net.Uri
import com.nammakelsa.data.model.WorkerProfile
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction over Firestore and Storage operations for worker profiles.
 */
interface WorkerRepository {

    /**
     * Creates a new worker profile document in Firestore under `workers/{uid}`.
     * Wrapped with a 3-second timeout.
     */
    suspend fun createProfile(profile: WorkerProfile): Result<Unit>

    /**
     * Partially updates an existing worker profile document.
     * [updates] is a map of Firestore field paths to new values.
     * Wrapped with a 3-second timeout.
     */
    suspend fun updateProfile(workerId: String, updates: Map<String, Any>): Result<Unit>

    /**
     * Fetches the worker profile for [workerId] as a one-shot read.
     */
    suspend fun getProfile(workerId: String): Result<WorkerProfile>

    /**
     * Returns a [Flow] that emits the latest [WorkerProfile] whenever the Firestore
     * document for [workerId] changes.
     */
    fun observeProfile(workerId: String): Flow<WorkerProfile>

    /**
     * Updates the `isAvailable` field for [workerId].
     * Wrapped with a 2-second timeout.
     */
    suspend fun setAvailability(workerId: String, available: Boolean): Result<Unit>

    /**
     * Uploads [imageUri] to Firebase Storage and appends the resulting download URL
     * to the worker's `galleryPhotoUrls` array in Firestore.
     *
     * Returns [Result.failure] if the gallery already contains 3 photos.
     *
     * @return [Result.success] with the download URL on success.
     */
    suspend fun addGalleryPhoto(workerId: String, imageUri: Uri): Result<String>

    /**
     * Removes [photoUrl] from Firebase Storage and from the worker's
     * `galleryPhotoUrls` array in Firestore.
     */
    suspend fun deleteGalleryPhoto(workerId: String, photoUrl: String): Result<Unit>
}
