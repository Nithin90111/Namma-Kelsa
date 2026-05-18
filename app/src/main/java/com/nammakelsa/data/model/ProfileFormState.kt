package com.nammakelsa.data.model

import android.net.Uri

/**
 * UI state for the worker registration and profile edit forms.
 */
data class ProfileFormState(
    val name: String = "",
    val skillType: SkillType? = null,
    val dailyRateInr: String = "",   // String for input field binding
    val profilePhotoUri: Uri? = null,
    val nameError: String? = null,
    val skillError: String? = null,
    val rateError: String? = null,
    val photoError: String? = null
)
