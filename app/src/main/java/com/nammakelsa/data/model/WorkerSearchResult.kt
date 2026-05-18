package com.nammakelsa.data.model

/**
 * Lightweight model used for worker cards in the customer search results list.
 */
data class WorkerSearchResult(
    val uid: String,
    val name: String,
    val skillType: SkillType,
    val dailyRateInr: Int,
    val distanceKm: Double,
    val profilePhotoUrl: String
)
