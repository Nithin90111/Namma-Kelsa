package com.nammakelsa.ui.customer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.nammakelsa.R
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.databinding.FragmentCustomerSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Customer-facing screen for discovering nearby available workers.
 *
 * Displays a skill [ChipGroup] and a radius [ChipGroup] as filters. Results are
 * shown in a [RecyclerView] backed by [WorkerCardAdapter]. Handles the
 * location-permission-denied state by showing an explanatory layout with a
 * deep-link to the app's system settings page.
 *
 * Requirements: 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7, 7.1, 7.3
 */
@AndroidEntryPoint
class CustomerSearchFragment : Fragment() {

    private var _binding: FragmentCustomerSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var workerCardAdapter: WorkerCardAdapter

    // -------------------------------------------------------------------------
    // Location permission launcher
    // -------------------------------------------------------------------------

    private val locationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.onLocationPermissionGranted()
        }
        // If denied, the ViewModel will surface locationPermissionDenied state
        // via the uiState flow, which the observer below will handle.
    }

    // -------------------------------------------------------------------------
    // Lifecycle
    // -------------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomerSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupChipListeners()
        setupSettingsButton()
        observeUiState()

        requestLocationPermissionIfNeeded()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // -------------------------------------------------------------------------
    // Setup helpers
    // -------------------------------------------------------------------------

    private fun setupRecyclerView() {
        workerCardAdapter = WorkerCardAdapter { workerId ->
            val action = CustomerSearchFragmentDirections
                .actionCustomerSearchToWorkerProfileView(workerId)
            findNavController().navigate(action)
        }
        binding.rvWorkers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = workerCardAdapter
        }
    }

    private fun setupChipListeners() {
        // Skill chip selection → trigger search with selected skill + current radius
        binding.chipGroupSkills.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val chip = group.findViewById<Chip>(checkedIds[0])
                val skill = chipTextToSkillType(chip.text.toString()) ?: return@setOnCheckedStateChangeListener
                viewModel.search(skill, getSelectedRadius())
            }
        }

        // Radius chip selection → trigger search with current skill + selected radius
        binding.chipGroupRadius.setOnCheckedStateChangeListener { _, _ ->
            val skill = getSelectedSkill() ?: return@setOnCheckedStateChangeListener
            viewModel.search(skill, getSelectedRadius())
        }
    }

    private fun setupSettingsButton() {
        binding.btnOpenSettings.setOnClickListener {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts("package", requireContext().packageName, null)
            }
            startActivity(intent)
        }
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collectLatest { state ->

                // Location permission denied — show rationale, hide everything else
                binding.layoutLocationDenied.visibility =
                    if (state.locationPermissionDenied) View.VISIBLE else View.GONE

                // Loading indicator
                binding.progressBar.visibility =
                    if (state.isLoading) View.VISIBLE else View.GONE

                // Error message
                binding.tvError.visibility =
                    if (state.error != null && !state.locationPermissionDenied) View.VISIBLE else View.GONE
                binding.tvError.text = state.error ?: ""

                // Empty state message
                binding.tvEmptyState.visibility =
                    if (state.isEmpty && !state.isLoading && !state.locationPermissionDenied) View.VISIBLE else View.GONE

                // Results list
                binding.rvWorkers.visibility =
                    if (state.results.isNotEmpty() && !state.locationPermissionDenied) View.VISIBLE else View.GONE
                workerCardAdapter.submitList(state.results)
            }
        }
    }

    // -------------------------------------------------------------------------
    // Permission
    // -------------------------------------------------------------------------

    private fun requestLocationPermissionIfNeeded() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    // -------------------------------------------------------------------------
    // Filter helpers
    // -------------------------------------------------------------------------

    private fun getSelectedSkill(): SkillType? {
        val checkedId = binding.chipGroupSkills.checkedChipId
        if (checkedId == View.NO_ID) return null
        val chip = binding.chipGroupSkills.findViewById<Chip>(checkedId)
        return chipTextToSkillType(chip.text.toString())
    }

    private fun getSelectedRadius(): Double {
        return when (binding.chipGroupRadius.checkedChipId) {
            R.id.chip1km -> 1.0
            R.id.chip2km -> 2.0
            R.id.chip10km -> 10.0
            else -> 5.0 // default: chip5km or no selection
        }
    }

    /**
     * Maps a chip label (e.g. "Painting") to the corresponding [SkillType] enum value.
     * Returns null if the label does not match any known skill.
     */
    private fun chipTextToSkillType(chipText: String): SkillType? {
        return try {
            SkillType.valueOf(chipText.uppercase().replace(" ", "_"))
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}
