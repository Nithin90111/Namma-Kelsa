package com.nammakelsa.data.model

/**
 * Sealed class representing the outcome of a form validation pass.
 */
sealed class ValidationResult {
    /** All fields passed validation. */
    object Valid : ValidationResult()

    /**
     * One or more fields failed validation.
     *
     * @param errors Non-empty list of field-level errors.
     */
    data class Invalid(val errors: List<FieldError>) : ValidationResult()
}
