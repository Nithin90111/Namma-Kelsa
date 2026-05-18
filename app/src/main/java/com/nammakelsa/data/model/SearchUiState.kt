package com.nammakelsa.data.model

/**
 * UI state for the customer search screen.
 *
 * [locationPermissionDenied] is set to true when the app does not have
 * ACCESS_FINE_LOCATION permission. The fragment should render an explanatory
 * message with a deep-link to Settings when this flag is true.
 */
data class SearchUiState(
    val selectedSkill: SkillType? = null,
    val radiusKm: Double = 5.0,
    val results: List<WorkerSearchResult> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isEmpty: Boolean = false,
    val locationPermissionDenied: Boolean = false
)
