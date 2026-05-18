package com.nammakelsa.domain.repository

import android.net.Uri

/**
 * Abstraction over Firebase Cloud Storage for image upload and deletion.
 */
interface StorageRepository {

    /**
     * Uploads the image at [imageUri] to the given Storage [path].
     *
     * @return [Result.success] with the public download URL on success, or
     *         [Result.failure] with the underlying [StorageException] on failure.
     */
    suspend fun uploadImage(path: String, imageUri: Uri): Result<String>

    /**
     * Deletes the image identified by its download [url] from Firebase Storage.
     */
    suspend fun deleteImage(url: String): Result<Unit>
}
