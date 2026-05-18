package com.nammakelsa.data.repository;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Priority;
import com.nammakelsa.data.model.LatLng;
import com.nammakelsa.data.model.LocationPermissionDeniedException;
import com.nammakelsa.domain.repository.LocationRepository;
import javax.inject.Inject;

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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000e"}, d2 = {"Lcom/nammakelsa/data/repository/LocationRepositoryImpl;", "Lcom/nammakelsa/domain/repository/LocationRepository;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "context", "Landroid/content/Context;", "(Lcom/google/android/gms/location/FusedLocationProviderClient;Landroid/content/Context;)V", "getCurrentLocation", "Lkotlin/Result;", "Lcom/nammakelsa/data/model/LatLng;", "getCurrentLocation-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasLocationPermission", "", "app_debug"})
public final class LocationRepositoryImpl implements com.nammakelsa.domain.repository.LocationRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public LocationRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Returns `true` if the app currently holds [Manifest.permission.ACCESS_FINE_LOCATION].
     */
    @java.lang.Override()
    public boolean hasLocationPermission() {
        return false;
    }
}