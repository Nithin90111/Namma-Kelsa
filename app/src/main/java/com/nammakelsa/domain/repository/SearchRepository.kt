package com.nammakelsa.domain.repository

import com.nammakelsa.data.model.LatLng
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.WorkerSearchResult
import kotlinx.coroutines.flow.Flow

/**
 * Abstraction over the Firestore geo-query used for customer worker discovery.
 */
interface SearchRepository {

    /**
     * Returns a [Flow] of worker search results that match [skill], are available,
     * and are within [radiusKm] of [customerLocation].
     *
     * Results are sorted by distance ascending (nearest first).
     * Workers with `isAvailable == false` are never included.
     */
    fun searchWorkers(
        skill: SkillType,
        customerLocation: LatLng,
        radiusKm: Double
    ): Flow<List<WorkerSearchResult>>
}
