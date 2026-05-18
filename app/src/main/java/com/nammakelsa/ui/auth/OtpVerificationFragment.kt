package com.nammakelsa.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.databinding.FragmentOtpVerificationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class OtpVerificationFragment : Fragment() {

    private var _binding: FragmentOtpVerificationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by viewModels()
    private val args: OtpVerificationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val verificationId = args.verificationId

        // If auto-verified, skip OTP entry and navigate directly to worker home
        if (verificationId == "AUTO_VERIFIED") {
            findNavController().navigate(
                OtpVerificationFragmentDirections.actionOtpVerificationToWorkerHome()
            )
            return
        }

        binding.btnVerify.setOnClickListener {
            val otp = binding.etOtp.text?.toString()?.trim() ?: ""
            viewModel.verifyOtp(verificationId, otp)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.verifyOtpState.collectLatest { state ->
                when (state) {
                    is UiResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnVerify.isEnabled = false
                        binding.tvError.visibility = View.GONE
                    }
                    is UiResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnVerify.isEnabled = true
                        val isNewUser = state.data
                        if (isNewUser) {
                            findNavController().navigate(
                                OtpVerificationFragmentDirections.actionOtpVerificationToRegistration()
                            )
                        } else {
                            findNavController().navigate(
                                OtpVerificationFragmentDirections.actionOtpVerificationToWorkerHome()
                            )
                        }
                    }
                    is UiResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnVerify.isEnabled = true
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = state.message
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.lockoutCountdown.collectLatest { remainingMs ->
                if (remainingMs > 0) {
                    val minutes = TimeUnit.MILLISECONDS.toMinutes(remainingMs)
                    val seconds = TimeUnit.MILLISECONDS.toSeconds(remainingMs) % 60
                    binding.tvLockoutCountdown.visibility = View.VISIBLE
                    binding.tvLockoutCountdown.text =
                        "Too many attempts. Try again in %02d:%02d".format(minutes, seconds)
                    binding.btnVerify.isEnabled = false
                } else {
                    binding.tvLockoutCountdown.visibility = View.GONE
                    binding.btnVerify.isEnabled = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
