package com.nammakelsa.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nammakelsa.data.model.UiResult
import com.nammakelsa.databinding.FragmentPhoneEntryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhoneEntryFragment : Fragment() {

    private var _binding: FragmentPhoneEntryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhoneEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSendOtp.setOnClickListener {
            val phone = binding.etPhoneNumber.text?.toString()?.trim() ?: ""
            viewModel.sendOtp(phone, requireActivity())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sendOtpState.collectLatest { state ->
                when (state) {
                    is UiResult.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.btnSendOtp.isEnabled = false
                        binding.tvError.visibility = View.GONE
                    }
                    is UiResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnSendOtp.isEnabled = true
                        val verificationId = state.data
                        if (verificationId == "AUTO_VERIFIED") {
                            // Auto-verified — navigate directly to worker home
                            findNavController().navigate(
                                PhoneEntryFragmentDirections.actionPhoneEntryToOtpVerification("AUTO_VERIFIED")
                            )
                        } else {
                            val action = PhoneEntryFragmentDirections
                                .actionPhoneEntryToOtpVerification(verificationId)
                            findNavController().navigate(action)
                        }
                    }
                    is UiResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnSendOtp.isEnabled = true
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = state.message
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
