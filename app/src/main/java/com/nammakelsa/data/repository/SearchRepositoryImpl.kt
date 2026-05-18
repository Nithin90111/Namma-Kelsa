package com.nammakelsa.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.nammakelsa.data.model.LatLng
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.WorkerProfile
import com.nammakelsa.data.model.WorkerSearchResult
import com.nammakelsa.domain.repository.SearchRepository
import com.nammakelsa.util.GeoHashUtil
import com.nammakelsa.util.HaversineUtil
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : SearchRepository {

    override fun searchWorkers(
        skill: SkillType,
        customerLocation: LatLng,
        radiusKm: Double
    ): Flow<List<WorkerSearchResult>> = callbackFlow {

        val bounds = GeoHashUtil.getQueryBounds(
            customerLocation.latitude,
            customerLocation.longitude,
            radiusKm
        )

        // Track results from each query range; merge on every update
        val resultsByRange = mutableMapOf<Int, List<WorkerProfile>>()
        val listeners = mutableListOf<com.google.firebase.firestore.ListenerRegistration>()

        bounds.forEachIndexed { index, (startHash, endHash) ->
            val query = firestore.collection("workers")
                .whereEqualTo("skillType", skill.name)
                .whereEqualTo("isAvailable", true)
                .whereGreaterThanOrEqualTo("geoHash", startHash)
                .whereLessThanOrEqualTo("geoHash", endHash)

            val listener = query.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                val profiles = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(WorkerProfile::class.java)
                } ?: emptyList()

                resultsByRange[index] = profiles

                // Merge all ranges, deduplicate by uid, filter by exact distance, sort
                val merged = resultsByRange.values
                    .flatten()
                    .distinctBy { it.uid }
                    .mapNotNull { profile ->
                        val distance = HaversineUtil.distanceKm(
                            customerLocation.latitude,
                            customerLocation.longitude,
                            profile.location.latitude,
                            profile.location.longitude
                        )
                        if (distance <= radiusKm) {
                            WorkerSearchResult(
                                uid = profile.uid,
                                name = profile.name,
                                skillType = profile.skillType,
                                dailyRateInr = profile.dailyRateInr,
                                distanceKm = distance,
                                profilePhotoUrl = profile.profilePhotoUrl
                            )
                        } else null
                    }
                    .sortedBy { it.distanceKm }

                trySend(merged)
            }

            listeners.add(listener)
        }

        awaitClose {
            listeners.forEach { it.remove() }
        }
    }
}
