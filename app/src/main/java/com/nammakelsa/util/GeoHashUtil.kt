package com.nammakelsa.util

import kotlin.math.*

/**
 * Utility object for GeoHash encoding and geo-query bound computation.
 *
 * GeoHash encodes a (lat, lng) coordinate into a string where nearby locations
 * share common prefixes. This enables efficient range queries in Firestore.
 *
 * Reference: https://firebase.google.com/docs/firestore/solutions/geoqueries
 */
object GeoHashUtil {

    private const val BASE32 = "0123456789bcdefghjkmnpqrstuvwxyz"
    private const val PRECISION = 9

    /**
     * Encodes [lat]/[lng] to a GeoHash string at [precision] characters.
     */
    fun encode(lat: Double, lng: Double, precision: Int = PRECISION): String {
        var minLat = -90.0
        var maxLat = 90.0
        var minLng = -180.0
        var maxLng = 180.0

        val hash = StringBuilder()
        var bits = 0
        var bitsTotal = 0
        var hashValue = 0
        var isEven = true

        while (hash.length < precision) {
            val mid: Double
            if (isEven) {
                mid = (minLng + maxLng) / 2
                if (lng > mid) {
                    hashValue = (hashValue shl 1) or 1
                    minLng = mid
                } else {
                    hashValue = hashValue shl 1
                    maxLng = mid
                }
            } else {
                mid = (minLat + maxLat) / 2
                if (lat > mid) {
                    hashValue = (hashValue shl 1) or 1
                    minLat = mid
                } else {
                    hashValue = hashValue shl 1
                    maxLat = mid
                }
            }
            isEven = !isEven
            bits++
            bitsTotal++

            if (bits == 5) {
                hash.append(BASE32[hashValue])
                bits = 0
                hashValue = 0
            }
        }
        return hash.toString()
    }

    /**
     * Decodes a GeoHash string to a (lat, lng) pair representing the center of the cell.
     */
    fun decode(geoHash: String): Pair<Double, Double> {
        var minLat = -90.0
        var maxLat = 90.0
        var minLng = -180.0
        var maxLng = 180.0
        var isEven = true

        for (char in geoHash) {
            val charIndex = BASE32.indexOf(char)
            for (bits in 4 downTo 0) {
                val bitN = (charIndex shr bits) and 1
                if (isEven) {
                    val mid = (minLng + maxLng) / 2
                    if (bitN == 1) minLng = mid else maxLng = mid
                } else {
                    val mid = (minLat + maxLat) / 2
                    if (bitN == 1) minLat = mid else maxLat = mid
                }
                isEven = !isEven
            }
        }
        return Pair((minLat + maxLat) / 2, (minLng + maxLng) / 2)
    }

    /**
     * Returns a list of GeoHash range pairs (startHash, endHash) that together cover
     * all points within [radiusKm] of ([centerLat], [centerLng]).
     *
     * Each pair represents an inclusive range query: WHERE geoHash >= start AND geoHash <= end.
     *
     * The approach:
     * 1. Determine the appropriate GeoHash precision for the radius.
     * 2. Compute the center GeoHash and its 8 neighbors.
     * 3. Return each cell as a range [cell, cell + "\uf8ff"] for Firestore prefix queries.
     */
    fun getQueryBounds(
        centerLat: Double,
        centerLng: Double,
        radiusKm: Double
    ): List<Pair<String, String>> {
        val precision = precisionForRadius(radiusKm)
        val centerHash = encode(centerLat, centerLng, precision)
        val neighbors = getNeighbors(centerLat, centerLng, precision)

        val cells = mutableSetOf(centerHash)
        cells.addAll(neighbors)

        return cells.map { cell -> Pair(cell, cell + "\uF8FF") }
    }

    /**
     * Determines the GeoHash precision level appropriate for the given radius.
     * Larger radius → lower precision (shorter hash, larger cells).
     */
    fun precisionForRadius(radiusKm: Double): Int {
        return when {
            radiusKm <= 0.6 -> 6
            radiusKm <= 1.2 -> 5
            radiusKm <= 5.0 -> 4
            radiusKm <= 20.0 -> 4
            else -> 3
        }
    }

    /**
     * Returns the GeoHash strings of the 8 neighboring cells around ([lat], [lng])
     * at the given [precision].
     */
    private fun getNeighbors(lat: Double, lng: Double, precision: Int): List<String> {
        // Approximate cell dimensions at this precision
        val latErr = latErrorForPrecision(precision)
        val lngErr = lngErrorForPrecision(precision)

        val neighbors = mutableListOf<String>()
        for (dLat in listOf(-latErr, 0.0, latErr)) {
            for (dLng in listOf(-lngErr, 0.0, lngErr)) {
                if (dLat == 0.0 && dLng == 0.0) continue
                val neighborLat = (lat + dLat).coerceIn(-90.0, 90.0)
                val neighborLng = wrapLng(lng + dLng)
                neighbors.add(encode(neighborLat, neighborLng, precision))
            }
        }
        return neighbors.distinct()
    }

    private fun latErrorForPrecision(precision: Int): Double {
        val bits = precision * 5
        val latBits = bits / 2
        return 180.0 / (1L shl latBits)
    }

    private fun lngErrorForPrecision(precision: Int): Double {
        val bits = precision * 5
        val lngBits = (bits + 1) / 2
        return 360.0 / (1L shl lngBits)
    }

    private fun wrapLng(lng: Double): Double {
        return when {
            lng > 180.0 -> lng - 360.0
            lng < -180.0 -> lng + 360.0
            else -> lng
        }
    }
}
