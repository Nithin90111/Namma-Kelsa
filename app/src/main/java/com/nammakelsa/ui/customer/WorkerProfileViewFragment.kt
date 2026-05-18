package com.nammakelsa.ui.customer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.snackbar.Snackbar
import com.nammakelsa.R
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.databinding.FragmentWorkerProfileViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorkerProfileViewFragment : Fragment() {

    private var _binding: FragmentWorkerProfileViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WorkerProfileViewViewModel by viewModels()
    private val args: WorkerProfileViewFragmentArgs by navArgs()

    // Hold a reference to the current phone number for the Call button click
    private var currentPhoneNumber: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkerProfileViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadProfile(args.workerId)

        // Call button — only fires if we have a phone number loaded
        binding.btnCall.setOnClickListener {
            if (currentPhoneNumber.isNotBlank()) {
                viewModel.onCallClicked(currentPhoneNumber)
            }
        }

        // Observe profile state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.profileState.collectLatest { state ->
                when (state) {
                    is UiResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.contentGroup.visibility = View.GONE
                        binding.tvError.visibility = View.GONE
                    }
                    is UiResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.GONE
                        binding.contentGroup.visibility = View.VISIBLE

                        val profile = state.data
                        currentPhoneNumber = profile.phoneNumber

                        binding.tvWorkerName.text = profile.name
                        binding.chipSkillBadge.text = profile.skillType.name
                            .lowercase()
                            .replaceFirstChar { it.uppercase() }
                        binding.tvDailyRate.text = "₹${profile.dailyRateInr}/day"
                        binding.tvLocation.text = "Location: ${profile.geoHash.take(6)}…"

                        // Profile photo (circular via Coil)
                        binding.ivProfilePhoto.load(profile.profilePhotoUrl) {
                            transformations(CircleCropTransformation())
                            placeholder(R.drawable.ic_person_placeholder)
                            error(R.drawable.ic_person_placeholder)
                        }

                        // Gallery photos — rebuild the container each time
                        binding.galleryContainer.removeAllViews()
                        profile.galleryPhotoUrls.forEach { url ->
                            val imageView = ImageView(requireContext()).apply {
                                val sizePx = resources.getDimensionPixelSize(R.dimen.gallery_photo_size)
                                val marginPx = resources.getDimensionPixelSize(R.dimen.gallery_photo_margin)
                                layoutParams = ViewGroup.MarginLayoutParams(sizePx, sizePx).apply {
                                    marginEnd = marginPx
                                }
                                scaleType = ImageView.ScaleType.CENTER_CROP
                                contentDescription = getString(R.string.gallery_photo_content_description)
                            }
                            imageView.load(url) {
                                placeholder(R.drawable.ic_person_placeholder)
                                error(R.drawable.ic_person_placeholder)
                            }
                            binding.galleryContainer.addView(imageView)
                        }
                    }
                    is UiResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.contentGroup.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = state.message
                    }
                }
            }
        }

        // Observe dialer events (one-shot SharedFlow)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dialerEvent.collect { phoneNumber ->
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                if (intent.resolveActivity(requireContext().packageManager) != null) {
                    startActivity(intent)
                } else {
                    Snackbar.make(
                        binding.root,
                        getString(R.string.error_calling_not_supported),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
