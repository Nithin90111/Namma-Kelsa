package com.nammakelsa.ui.customer;

import androidx.lifecycle.ViewModel;
import com.nammakelsa.data.model.LatLng;
import com.nammakelsa.data.model.LocationPermissionDeniedException;
import com.nammakelsa.data.model.SearchUiState;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.SearchRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

/**
 * ViewModel for the customer search screen.
 *
 * Responsibilities:
 * - Fetch the device's current location on init and cache it.
 * - Expose [uiState] as a [StateFlow] of [SearchUiState].
 * - Execute worker searches via [SearchRepository] using the cached location.
 * - Surface location-permission-denied state so the fragment can prompt the user.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/nammakelsa/ui/customer/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "searchRepository", "Lcom/nammakelsa/domain/repository/SearchRepository;", "locationRepository", "Lcom/nammakelsa/domain/repository/LocationRepository;", "(Lcom/nammakelsa/domain/repository/SearchRepository;Lcom/nammakelsa/domain/repository/LocationRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nammakelsa/data/model/SearchUiState;", "currentLocation", "Lcom/nammakelsa/data/model/LatLng;", "searchJob", "Lkotlinx/coroutines/Job;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchLocation", "", "onLocationPermissionGranted", "search", "skill", "Lcom/nammakelsa/data/model/SkillType;", "radiusKm", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.SearchRepository searchRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.LocationRepository locationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.SearchUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.SearchUiState> uiState = null;
    
    /**
     * Cached GPS coordinates from the most recent successful location fetch.
     */
    @org.jetbrains.annotations.Nullable()
    private com.nammakelsa.data.model.LatLng currentLocation;
    
    /**
     * Handle to the currently running search coroutine so it can be cancelled on a new search.
     */
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job searchJob;
    
    @javax.inject.Inject()
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.SearchRepository searchRepository, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.LocationRepository locationRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.SearchUiState> getUiState() {
        return null;
    }
    
    private final void fetchLocation() {
    }
    
    /**
     * Called by the fragment after the user grants ACCESS_FINE_LOCATION.
     * Re-fetches the location and clears the permission-denied state.
     */
    public final void onLocationPermissionGranted() {
    }
    
    /**
     * Starts a new worker search for [skill] within [radiusKm] of the cached location.
     *
     * If location permission is denied, sets [SearchUiState.locationPermissionDenied].
     * If the location has not yet been resolved (but permission is granted), surfaces an error.
     */
    public final void search(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skill, double radiusKm) {
    }
}