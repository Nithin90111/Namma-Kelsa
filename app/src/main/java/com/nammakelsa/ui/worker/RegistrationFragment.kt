package com.nammakelsa.ui.worker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.nammakelsa.R
import com.nammakelsa.data.model.SkillType
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels()

    private val photoPicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            viewModel.updateProfilePhotoUri(it)
            binding.ivProfilePhoto.load(it) {
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_person_placeholder)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Profile photo picker
        binding.ivProfilePhoto.setOnClickListener {
            photoPicker.launch("image/*")
        }

        // Name input
        binding.etName.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.updateName(s?.toString() ?: "")
            }
            override fun afterTextChanged(s: android.text.Editable?) {}
        })

        // Skill chip selection
        binding.chipGroupSkills.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val chip = group.findViewById<Chip>(checkedIds[0])
                val skillName = chip.text.toString().uppercase().replace(" ", "_")
                try {
                    viewModel.updateSkillType(SkillType.valueOf(skillName))
                } catch (e: IllegalArgumentException) {
                    // Ignore unknown chip text
                }
            }
        }

        // Daily rate input
        binding.etDailyRate.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.updateDailyRate(s?.toString() ?: "")
            }
            override fun afterTextChanged(s: android.text.Editable?) {}
        })

        // Submit button
        binding.btnCreateProfile.setOnClickListener {
            viewModel.onSubmit()
        }

        // Observe form state for field-level errors
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.formState.collectLatest { form ->
                binding.tvNameError.text = form.nameError ?: ""
                binding.tvNameError.visibility = if (form.nameError != null) View.VISIBLE else View.GONE

                binding.tvSkillError.text = form.skillError ?: ""
                binding.tvSkillError.visibility = if (form.skillError != null) View.VISIBLE else View.GONE

                binding.tvRateError.text = form.rateError ?: ""
                binding.tvRateError.visibility = if (form.rateError != null) View.VISIBLE else View.GONE

                binding.tvPhotoError.text = form.photoError ?: ""
                binding.tvPhotoError.visibility = if (form.photoError != null) View.VISIBLE else View.GONE
            }
        }

        // Observe registration state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.registrationState.collectLatest { state ->
                when (state) {
                    null -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnCreateProfile.isEnabled = true
                    }
                    is UiResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnCreateProfile.isEnabled = false
                    }
                    is UiResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_registration_to_workerHome)
                    }
                    is UiResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnCreateProfile.isEnabled = true
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
