package com.nammakelsa.ui.worker

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammakelsa.R

public class RegistrationFragmentDirections private constructor() {
  public companion object {
    public fun actionRegistrationToWorkerHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registration_to_workerHome)
  }
}
