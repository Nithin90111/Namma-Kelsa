package com.nammakelsa.data.model

/**
 * Represents a validation error for a specific form field.
 *
 * @param field  The name of the field that failed validation (e.g. "name", "dailyRateInr").
 * @param message A human-readable description of the validation failure.
 */
data class FieldError(
    val field: String,
    val message: String
)
