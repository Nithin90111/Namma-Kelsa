package com.nammakelsa.util;

import kotlin.math.*;

/**
 * Utility object for computing great-circle distances between two geographic coordinates
 * using the Haversine formula.
 *
 * Used for client-side distance filtering and sorting after the GeoHash range query.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/nammakelsa/util/HaversineUtil;", "", "()V", "EARTH_RADIUS_KM", "", "distanceKm", "lat1", "lng1", "lat2", "lng2", "app_debug"})
public final class HaversineUtil {
    private static final double EARTH_RADIUS_KM = 6371.0;
    @org.jetbrains.annotations.NotNull()
    public static final com.nammakelsa.util.HaversineUtil INSTANCE = null;
    
    private HaversineUtil() {
        super();
    }
    
    /**
     * Computes the great-circle distance in kilometres between two points
     * ([lat1], [lng1]) and ([lat2], [lng2]).
     *
     * @return Distance in kilometres (always ≥ 0).
     */
    public final double distanceKm(double lat1, double lng1, double lat2, double lng2) {
        return 0.0;
    }
}