package com.nammakelsa.util;

import kotlin.math.*;

/**
 * Utility object for GeoHash encoding and geo-query bound computation.
 *
 * GeoHash encodes a (lat, lng) coordinate into a string where nearby locations
 * share common prefixes. This enables efficient range queries in Firestore.
 *
 * Reference: https://firebase.google.com/docs/firestore/solutions/geoqueries
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0006J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J0\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u00102\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/nammakelsa/util/GeoHashUtil;", "", "()V", "BASE32", "", "PRECISION", "", "decode", "Lkotlin/Pair;", "", "geoHash", "encode", "lat", "lng", "precision", "getNeighbors", "", "getQueryBounds", "centerLat", "centerLng", "radiusKm", "latErrorForPrecision", "lngErrorForPrecision", "precisionForRadius", "wrapLng", "app_debug"})
public final class GeoHashUtil {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE32 = "0123456789bcdefghjkmnpqrstuvwxyz";
    private static final int PRECISION = 9;
    @org.jetbrains.annotations.NotNull()
    public static final com.nammakelsa.util.GeoHashUtil INSTANCE = null;
    
    private GeoHashUtil() {
        super();
    }
    
    /**
     * Encodes [lat]/[lng] to a GeoHash string at [precision] characters.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encode(double lat, double lng, int precision) {
        return null;
    }
    
    /**
     * Decodes a GeoHash string to a (lat, lng) pair representing the center of the cell.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Double, java.lang.Double> decode(@org.jetbrains.annotations.NotNull()
    java.lang.String geoHash) {
        return null;
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
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> getQueryBounds(double centerLat, double centerLng, double radiusKm) {
        return null;
    }
    
    /**
     * Determines the GeoHash precision level appropriate for the given radius.
     * Larger radius → lower precision (shorter hash, larger cells).
     */
    public final int precisionForRadius(double radiusKm) {
        return 0;
    }
    
    /**
     * Returns the GeoHash strings of the 8 neighboring cells around ([lat], [lng])
     * at the given [precision].
     */
    private final java.util.List<java.lang.String> getNeighbors(double lat, double lng, int precision) {
        return null;
    }
    
    private final double latErrorForPrecision(int precision) {
        return 0.0;
    }
    
    private final double lngErrorForPrecision(int precision) {
        return 0.0;
    }
    
    private final double wrapLng(double lng) {
        return 0.0;
    }
}