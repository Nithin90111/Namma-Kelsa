package com.nammakelsa.domain.repository

import com.nammakelsa.data.model.LatLng
import com.nammakelsa.data.model.LocationPermissionDeniedException

/**
 * Abstraction over the Android location system for GPS coordinate retrieval.
 */
interface LocationRepository {

    /**
     * Returns the device's current GPS coordinates.
     *
     * @return [Result.success] with the current [LatLng] on success, or
     *         [Result.failure] with [LocationPermissionDeniedException] if
     *         ACCESS_FINE_LOCATION permission has not been granted.
     */
    suspend fun getCurrentLocation(): Result<LatLng>

    /** Returns true if the app currently holds ACCESS_FINE_LOCATION permission. */
    fun hasLocationPermission(): Boolean
}
