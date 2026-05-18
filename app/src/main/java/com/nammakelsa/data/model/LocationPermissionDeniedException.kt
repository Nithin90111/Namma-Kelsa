package com.nammakelsa.data.model

/**
 * Thrown by [com.nammakelsa.domain.repository.LocationRepository] when the app does not
 * have ACCESS_FINE_LOCATION permission at the time of the location request.
 */
class LocationPermissionDeniedException(
    message: String = "Location permission has not been granted"
) : Exception(message)
