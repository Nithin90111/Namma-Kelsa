package com.nammakelsa.ui.worker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
import com.nammakelsa.databinding.FragmentWorkerProfileEditBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkerProfileEditFragment : Fragment() {

    private var _binding: FragmentWorkerProfileEditBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WorkerProfileViewModel by viewModels()

    private val profilePhotoPicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            viewModel.updateProfilePhotoUri(it)
            binding.ivProfilePhoto.load(it) {
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_person_placeholder)
            }
        }
    }

    private val galleryPhotoPicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { viewModel.addGalleryPhoto(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkerProfileEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Profile photo picker
        binding.ivProfilePhoto.setOnClickListener {
            profilePhotoPicker.launch("image/*")
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
                } catch (e: IllegalArgumentException) { /* ignore */ }
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

        // Update location button
        binding.btnUpdateLocation.setOnClickListener {
            Toast.makeText(requireContext(), "Location will be updated when you save", Toast.LENGTH_SHORT).show()
        }

        // Add gallery photo
        binding.btnAddPhoto.setOnClickListener {
            galleryPhotoPicker.launch("image/*")
        }

        // Save button
        binding.btnSaveChanges.setOnClickListener {
            viewModel.onSave()
        }

        // Observe form state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.formState.collectLatest { form ->
                // Pre-populate name (only if not currently focused to avoid cursor jump)
                if (!binding.etName.isFocused && binding.etName.text?.toString() != form.name) {
                    binding.etName.setText(form.name)
                }
                // Pre-populate daily rate
                if (!binding.etDailyRate.isFocused && binding.etDailyRate.text?.toString() != form.dailyRateInr) {
                    binding.etDailyRate.setText(form.dailyRateInr)
                }

                // Pre-select skill chip
                form.skillType?.let { skill ->
                    val chipId = skillTypeToChipId(skill)
                    if (chipId != View.NO_ID && binding.chipGroupSkills.checkedChipId != chipId) {
                        binding.chipGroupSkills.check(chipId)
                    }
                }

                // Field errors
                binding.tvNameError.text = form.nameError ?: ""
                binding.tvNameError.visibility = if (form.nameError != null) View.VISIBLE else View.GONE
                binding.tvSkillError.text = form.skillError ?: ""
                binding.tvSkillError.visibility = if (form.skillError != null) View.VISIBLE else View.GONE
                binding.tvRateError.text = form.rateError ?: ""
                binding.tvRateError.visibility = if (form.rateError != null) View.VISIBLE else View.GONE
            }
        }

        // Observe gallery state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.galleryState.collectLatest { urls ->
                updateGalleryGrid(urls)
                binding.btnAddPhoto.visibility = if (urls.size < 3) View.VISIBLE else View.GONE
            }
        }

        // Observe confirmation events
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.confirmationEvent.collect { message ->
                Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
            }
        }

        // Observe save state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.saveState.collectLatest { state ->
                when (state) {
                    null -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnSaveChanges.isEnabled = true
                    }
                    is UiResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnSaveChanges.isEnabled = false
                    }
                    is UiResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        findNavController().navigateUp()
                    }
                    is UiResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnSaveChanges.isEnabled = true
                        Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun skillTypeToChipId(skill: SkillType): Int = when (skill) {
        SkillType.PAINTING -> R.id.chipPainting
        SkillType.TILING -> R.id.chipTiling
        SkillType.PLUMBING -> R.id.chipPlumbing
        SkillType.ELECTRICAL -> R.id.chipElectrical
        SkillType.GARDENING -> R.id.chipGardening
        SkillType.CARPENTRY -> R.id.chipCarpentry
    }

    private fun updateGalleryGrid(urls: List<String>) {
        binding.galleryContainer.removeAllViews()
        urls.forEach { url ->
            val itemView = layoutInflater.inflate(R.layout.item_gallery_photo, binding.galleryContainer, false)
            val imageView = itemView.findViewById<android.widget.ImageView>(R.id.ivGalleryPhoto)
            val deleteButton = itemView.findViewById<android.widget.ImageButton>(R.id.btnDeletePhoto)

            imageView.load(url) { placeholder(R.drawable.ic_person_placeholder) }
            deleteButton.setOnClickListener { viewModel.deleteGalleryPhoto(url) }

            binding.galleryContainer.addView(itemView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
