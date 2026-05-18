package com.nammakelsa.data.model

/**
 * Sealed class representing the result of an async UI operation.
 */
sealed class UiResult<out T> {
    object Loading : UiResult<Nothing>()
    data class Success<T>(val data: T) : UiResult<T>()
    data class Error(val message: String) : UiResult<Nothing>()
}
