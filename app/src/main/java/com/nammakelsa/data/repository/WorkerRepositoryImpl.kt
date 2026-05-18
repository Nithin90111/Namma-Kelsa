package com.nammakelsa.data.repository

import android.net.Uri
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.nammakelsa.data.model.WorkerProfile
import com.nammakelsa.domain.repository.StorageRepository
import com.nammakelsa.domain.repository.WorkerRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import java.util.UUID
import javax.inject.Inject

class WorkerRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storageRepository: StorageRepository
) : WorkerRepository {

    private fun workersCollection() = firestore.collection("workers")

    override suspend fun createProfile(profile: WorkerProfile): Result<Unit> = runCatching {
        withTimeout(3000) {
            workersCollection().document(profile.uid).set(profile).await()
        }
    }

    override suspend fun updateProfile(workerId: String, updates: Map<String, Any>): Result<Unit> = runCatching {
        withTimeout(3000) {
            val updatesWithTimestamp = updates.toMutableMap()
            updatesWithTimestamp["updatedAt"] = Timestamp.now()
            workersCollection().document(workerId).update(updatesWithTimestamp).await()
        }
    }

    override suspend fun getProfile(workerId: String): Result<WorkerProfile> = runCatching {
        val snapshot = workersCollection().document(workerId).get().await()
        snapshot.toObject(WorkerProfile::class.java)
            ?: throw Exception("Worker profile not found for id: $workerId")
    }

    override fun observeProfile(workerId: String): Flow<WorkerProfile> = callbackFlow {
        val listener = workersCollection().document(workerId)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                val profile = snapshot?.toObject(WorkerProfile::class.java)
                if (profile != null) {
                    trySend(profile)
                }
            }
        awaitClose { listener.remove() }
    }

    override suspend fun setAvailability(workerId: String, available: Boolean): Result<Unit> = runCatching {
        withTimeout(2000) {
            workersCollection().document(workerId)
                .update("isAvailable", available)
                .await()
        }
    }

    override suspend fun addGalleryPhoto(workerId: String, imageUri: Uri): Result<String> {
        // Check current gallery size before uploading
        val profileResult = getProfile(workerId)
        if (profileResult.isFailure) return Result.failure(profileResult.exceptionOrNull()!!)

        val profile = profileResult.getOrNull()!!
        if (profile.galleryPhotoUrls.size >= 3) {
            return Result.failure(Exception("Gallery limit of 3 photos reached"))
        }

        // Upload the image to Storage
        val storagePath = "gallery-photos/$workerId/${UUID.randomUUID()}.jpg"
        val uploadResult = storageRepository.uploadImage(storagePath, imageUri)
        if (uploadResult.isFailure) return Result.failure(uploadResult.exceptionOrNull()!!)

        val downloadUrl = uploadResult.getOrNull()!!

        // Append the download URL to the galleryPhotoUrls array in Firestore
        return runCatching {
            workersCollection().document(workerId)
                .update("galleryPhotoUrls", FieldValue.arrayUnion(downloadUrl))
                .await()
            downloadUrl
        }
    }

    override suspend fun deleteGalleryPhoto(workerId: String, photoUrl: String): Result<Unit> {
        // Delete the file from Firebase Storage first
        val deleteResult = storageRepository.deleteImage(photoUrl)
        if (deleteResult.isFailure) return Result.failure(deleteResult.exceptionOrNull()!!)

        // Remove the URL from the galleryPhotoUrls array in Firestore
        return runCatching {
            workersCollection().document(workerId)
                .update("galleryPhotoUrls", FieldValue.arrayRemove(photoUrl))
                .await()
        }
    }
}
