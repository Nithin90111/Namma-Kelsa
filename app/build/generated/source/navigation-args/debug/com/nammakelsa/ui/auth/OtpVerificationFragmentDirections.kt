package com.nammakelsa.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammakelsa.R

public class OtpVerificationFragmentDirections private constructor() {
  public companion object {
    public fun actionOtpVerificationToRegistration(): NavDirections =
        ActionOnlyNavDirections(R.id.action_otpVerification_to_registration)

    public fun actionOtpVerificationToWorkerHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_otpVerification_to_workerHome)
  }
}
