package com.nammakelsa.domain.repository;

import com.nammakelsa.data.model.LatLng;
import com.nammakelsa.data.model.LocationPermissionDeniedException;

/**
 * Abstraction over the Android location system for GPS coordinate retrieval.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\t"}, d2 = {"Lcom/nammakelsa/domain/repository/LocationRepository;", "", "getCurrentLocation", "Lkotlin/Result;", "Lcom/nammakelsa/data/model/LatLng;", "getCurrentLocation-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasLocationPermission", "", "app_debug"})
public abstract interface LocationRepository {
    
    /**
     * Returns true if the app currently holds ACCESS_FINE_LOCATION permission.
     */
    public abstract boolean hasLocationPermission();
}