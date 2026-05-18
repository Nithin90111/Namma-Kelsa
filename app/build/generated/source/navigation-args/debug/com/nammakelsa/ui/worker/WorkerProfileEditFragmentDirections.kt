package com.nammakelsa.ui.worker

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammakelsa.R

public class WorkerProfileEditFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileEditToWorkerHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileEdit_to_workerHome)
  }
}
