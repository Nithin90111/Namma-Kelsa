package com.nammakelsa.data.repository

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.nammakelsa.domain.repository.StorageRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class StorageRepositoryImpl @Inject constructor(
    private val storage: FirebaseStorage
) : StorageRepository {

    override suspend fun uploadImage(path: String, imageUri: Uri): Result<String> =
        suspendCancellableCoroutine { continuation ->
            val ref = storage.reference.child(path)
            val uploadTask = ref.putFile(imageUri)

            uploadTask
                .addOnSuccessListener {
                    // Get the download URL after successful upload
                    ref.downloadUrl
                        .addOnSuccessListener { uri ->
                            if (continuation.isActive) {
                                continuation.resume(Result.success(uri.toString()))
                            }
                        }
                        .addOnFailureListener { e ->
                            if (continuation.isActive) {
                                continuation.resume(Result.failure(e))
                            }
                        }
                }
                .addOnFailureListener { e ->
                    if (continuation.isActive) {
                        continuation.resume(Result.failure(e))
                    }
                }

            continuation.invokeOnCancellation {
                uploadTask.cancel()
            }
        }

    override suspend fun deleteImage(url: String): Result<Unit> =
        suspendCancellableCoroutine { continuation ->
            try {
                val ref = storage.getReferenceFromUrl(url)
                ref.delete()
                    .addOnSuccessListener {
                        if (continuation.isActive) {
                            continuation.resume(Result.success(Unit))
                        }
                    }
                    .addOnFailureListener { e ->
                        if (continuation.isActive) {
                            continuation.resume(Result.failure(e))
                        }
                    }
            } catch (e: Exception) {
                if (continuation.isActive) {
                    continuation.resume(Result.failure(e))
                }
            }
        }
}
