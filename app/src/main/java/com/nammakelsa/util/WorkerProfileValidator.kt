package com.nammakelsa.util

import android.net.Uri
import com.nammakelsa.data.model.FieldError
import com.nammakelsa.data.model.ProfileFormState
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.ValidationResult

/**
 * Pure validation functions for the worker registration and profile edit forms.
 *
 * All functions are stateless and side-effect-free, making them straightforward
 * to unit-test and property-test.
 */
object WorkerProfileValidator {

    private const val MAX_NAME_LENGTH = 100

    /**
     * Validates all fields in [formState].
     *
     * @param isRegistration When true, [ProfileFormState.profilePhotoUri] is required.
     * @return [ValidationResult.Valid] if all fields pass, or
     *         [ValidationResult.Invalid] with a non-empty list of [FieldError]s.
     */
    fun validate(
        formState: ProfileFormState,
        isRegistration: Boolean = false
    ): ValidationResult {
        val errors = mutableListOf<FieldError>()

        // Name validation
        when {
            formState.name.isBlank() ->
                errors.add(FieldError("name", "Name is required"))
            formState.name.length > MAX_NAME_LENGTH ->
                errors.add(FieldError("name", "Name must be $MAX_NAME_LENGTH characters or fewer"))
        }

        // Skill type validation
        if (formState.skillType == null) {
            errors.add(FieldError("skillType", "Please select a skill"))
        }

        // Daily rate validation
        if (!validateDailyRate(formState.dailyRateInr)) {
            errors.add(FieldError("dailyRateInr", "Enter a valid daily rate (positive number)"))
        }

        // Profile photo validation (required only during registration)
        if (isRegistration && formState.profilePhotoUri == null) {
            errors.add(FieldError("profilePhotoUri", "Profile photo is required"))
        }

        return if (errors.isEmpty()) ValidationResult.Valid
        else ValidationResult.Invalid(errors)
    }

    /**
     * Returns true if [input] represents a positive integer (> 0).
     *
     * Accepts only strings that parse to an integer strictly greater than zero.
     * Rejects empty strings, zero, negative numbers, decimals, and non-numeric input.
     *
     * Property 2: Daily rate validation rejects non-positive values.
     */
    fun validateDailyRate(input: String): Boolean {
        if (input.isBlank()) return false
        val value = input.trim().toIntOrNull() ?: return false
        return value > 0
    }
}
