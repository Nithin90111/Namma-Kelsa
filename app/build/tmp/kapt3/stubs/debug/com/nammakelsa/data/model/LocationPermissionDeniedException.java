package com.nammakelsa.data.model;

/**
 * Thrown by [com.nammakelsa.domain.repository.LocationRepository] when the app does not
 * have ACCESS_FINE_LOCATION permission at the time of the location request.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/nammakelsa/data/model/LocationPermissionDeniedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "app_debug"})
public final class LocationPermissionDeniedException extends java.lang.Exception {
    
    public LocationPermissionDeniedException(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super();
    }
    
    public LocationPermissionDeniedException() {
        super();
    }
}