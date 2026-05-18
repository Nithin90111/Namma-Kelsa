package com.nammakelsa.data.model

/**
 * Simple data class representing a geographic coordinate pair.
 *
 * Used throughout the app to avoid a dependency on the Google Maps SDK
 * ([com.google.android.gms.maps.model.LatLng]) in layers that don't render maps.
 */
data class LatLng(val latitude: Double, val longitude: Double)
