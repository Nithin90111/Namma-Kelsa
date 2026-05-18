package com.nammakelsa.ui.worker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nammakelsa.R
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.databinding.FragmentWorkerHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkerHomeFragment : Fragment() {

    private var _binding: FragmentWorkerHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WorkerHomeViewModel by viewModels()

    // Flag to prevent feedback loop when programmatically updating the switch
    private var isUpdatingSwitch = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkerHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Availability toggle — only forward user-initiated changes to the ViewModel
        binding.switchAvailability.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdatingSwitch) {
                viewModel.setAvailability(isChecked)
            }
        }

        // Edit Profile button
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_workerHome_to_profileEdit)
        }

        // Browse as Customer button
        binding.btnBrowseAsCustomer.setOnClickListener {
            findNavController().navigate(R.id.action_workerHome_to_customerSearch)
        }

        // Observe profile state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.profileState.collectLatest { profile ->
                profile?.let {
                    binding.tvWelcome.text = "Welcome, ${it.name}!"
                    binding.chipSkill.text = it.skillType.name.lowercase()
                        .replaceFirstChar { c -> c.uppercase() }
                    binding.tvDailyRate.text = "₹${it.dailyRateInr}/day"

                    // Update switch without triggering the listener
                    isUpdatingSwitch = true
                    binding.switchAvailability.isChecked = it.isAvailable
                    isUpdatingSwitch = false
                }
            }
        }

        // Observe availability toggle state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.availabilityState.collectLatest { state ->
                when (state) {
                    is UiResult.Error -> {
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                        // Revert switch to match actual profile state
                        val currentAvailability = viewModel.profileState.value?.isAvailable ?: false
                        isUpdatingSwitch = true
                        binding.switchAvailability.isChecked = currentAvailability
                        isUpdatingSwitch = false
                    }
                    else -> { /* Loading and Success are handled silently */ }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
