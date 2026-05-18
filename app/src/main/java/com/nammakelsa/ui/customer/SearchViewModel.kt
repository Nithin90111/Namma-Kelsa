package com.nammakelsa.ui.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nammakelsa.data.model.LatLng
import com.nammakelsa.data.model.LocationPermissionDeniedException
import com.nammakelsa.data.model.SearchUiState
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.domain.repository.LocationRepository
import com.nammakelsa.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the customer search screen.
 *
 * Responsibilities:
 * - Fetch the device's current location on init and cache it.
 * - Expose [uiState] as a [StateFlow] of [SearchUiState].
 * - Execute worker searches via [SearchRepository] using the cached location.
 * - Surface location-permission-denied state so the fragment can prompt the user.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    /** Cached GPS coordinates from the most recent successful location fetch. */
    private var currentLocation: LatLng? = null

    /** Handle to the currently running search coroutine so it can be cancelled on a new search. */
    private var searchJob: Job? = null

    init {
        fetchLocation()
    }

    // -------------------------------------------------------------------------
    // Location
    // -------------------------------------------------------------------------

    private fun fetchLocation() {
        viewModelScope.launch {
            locationRepository.getCurrentLocation().fold(
                onSuccess = { latLng ->
                    currentLocation = latLng
                    // Clear any previous permission-denied state now that we have a location.
                    if (_uiState.value.locationPermissionDenied) {
                        _uiState.value = _uiState.value.copy(locationPermissionDenied = false)
                    }
                },
                onFailure = { e ->
                    if (e is LocationPermissionDeniedException) {
                        _uiState.value = _uiState.value.copy(
                            locationPermissionDenied = true,
                            isLoading = false
                        )
                    } else {
                        _uiState.value = _uiState.value.copy(
                            error = "Could not get location: ${e.message}",
                            isLoading = false
                        )
                    }
                }
            )
        }
    }

    /**
     * Called by the fragment after the user grants ACCESS_FINE_LOCATION.
     * Re-fetches the location and clears the permission-denied state.
     */
    fun onLocationPermissionGranted() {
        fetchLocation()
    }

    // -------------------------------------------------------------------------
    // Search
    // -------------------------------------------------------------------------

    /**
     * Starts a new worker search for [skill] within [radiusKm] of the cached location.
     *
     * If location permission is denied, sets [SearchUiState.locationPermissionDenied].
     * If the location has not yet been resolved (but permission is granted), surfaces an error.
     */
    fun search(skill: SkillType, radiusKm: Double) {
        val location = currentLocation

        if (location == null) {
            if (!locationRepository.hasLocationPermission()) {
                _uiState.value = _uiState.value.copy(locationPermissionDenied = true)
            } else {
                _uiState.value = _uiState.value.copy(
                    error = "Location not available yet. Please try again.",
                    isLoading = false
                )
            }
            return
        }

        // Cancel any in-flight search before starting a new one.
        searchJob?.cancel()

        searchJob = viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                selectedSkill = skill,
                radiusKm = radiusKm,
                isLoading = true,
                error = null,
                isEmpty = false,
                locationPermissionDenied = false
            )

            searchRepository.searchWorkers(skill, location, radiusKm)
                .catch { e ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = e.message ?: "Search failed"
                    )
                }
                .collect { results ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        results = results,
                        isEmpty = results.isEmpty(),
                        error = null
                    )
                }
        }
    }
}
