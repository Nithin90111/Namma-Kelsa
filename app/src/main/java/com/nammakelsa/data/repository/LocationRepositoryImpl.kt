package com.nammakelsa.data.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority
import com.nammakelsa.data.model.LatLng
import com.nammakelsa.data.model.LocationPermissionDeniedException
import com.nammakelsa.domain.repository.LocationRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Production implementation of [LocationRepository] backed by [FusedLocationProviderClient].
 *
 * Requires [Manifest.permission.ACCESS_FINE_LOCATION] to be granted before calling
 * [getCurrentLocation]. If the permission is absent the method returns immediately with
 * [Result.failure] wrapping a [LocationPermissionDeniedException].
 *
 * @param fusedLocationClient Provided by Hilt via the app-level DI module.
 * @param context Application context used for permission checks.
 */
class LocationRepositoryImpl @Inject constructor(
    private val fusedLocationClient: FusedLocationProviderClient,
    private val context: Context
) : LocationRepository {

    /**
     * Returns the device's current GPS coordinates.
     *
     * Strategy:
     * 1. Check [ACCESS_FINE_LOCATION] permission — fail fast if absent.
     * 2. Request a fresh fix via [FusedLocationProviderClient.getCurrentLocation] at
     *    [Priority.PRIORITY_HIGH_ACCURACY].
     * 3. If the fresh fix is null (GPS unavailable / cold start), fall back to
     *    [FusedLocationProviderClient.lastLocation].
     * 4. If both are null, return [Result.failure] with a descriptive message.
     */
    override suspend fun getCurrentLocation(): Result<LatLng> {
        if (!hasLocationPermission()) {
            return Result.failure(LocationPermissionDeniedException())
        }

        return try {
            val location = fusedLocationClient
                .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
                .await()

            if (location != null) {
                Result.success(LatLng(location.latitude, location.longitude))
            } else {
                // Fallback: use the last known location cached by the fused provider
                val lastLocation = fusedLocationClient.lastLocation.await()
                if (lastLocation != null) {
                    Result.success(LatLng(lastLocation.latitude, lastLocation.longitude))
                } else {
                    Result.failure(Exception("Location unavailable. Please ensure GPS is enabled."))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Returns `true` if the app currently holds [Manifest.permission.ACCESS_FINE_LOCATION].
     */
    override fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
}
