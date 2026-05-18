package com.nammakelsa.util

import kotlin.math.*

/**
 * Utility object for computing great-circle distances between two geographic coordinates
 * using the Haversine formula.
 *
 * Used for client-side distance filtering and sorting after the GeoHash range query.
 */
object HaversineUtil {

    private const val EARTH_RADIUS_KM = 6371.0

    /**
     * Computes the great-circle distance in kilometres between two points
     * ([lat1], [lng1]) and ([lat2], [lng2]).
     *
     * @return Distance in kilometres (always ≥ 0).
     */
    fun distanceKm(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
        val dLat = Math.toRadians(lat2 - lat1)
        val dLng = Math.toRadians(lng2 - lng1)

        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLng / 2).pow(2)

        val c = 2 * asin(sqrt(a))
        return EARTH_RADIUS_KM * c
    }
}
