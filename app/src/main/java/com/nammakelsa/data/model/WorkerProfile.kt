package com.nammakelsa.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint

/**
 * Represents a worker's full profile stored in Firestore under `workers/{uid}`.
 * Default values are required for Firestore deserialization.
 */
data class WorkerProfile(
    val uid: String = "",
    val name: String = "",
    val phoneNumber: String = "",
    val skillType: SkillType = SkillType.PAINTING,
    val dailyRateInr: Int = 0,
    val location: GeoPoint = GeoPoint(0.0, 0.0),
    val geoHash: String = "",
    val profilePhotoUrl: String = "",
    val galleryPhotoUrls: List<String> = emptyList(), // max 3 items
    val isAvailable: Boolean = false,
    val createdAt: Timestamp = Timestamp.now(),
    val updatedAt: Timestamp = Timestamp.now()
)
