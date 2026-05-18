package com.nammakelsa.ui.worker

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammakelsa.R

public class WorkerHomeFragmentDirections private constructor() {
  public companion object {
    public fun actionWorkerHomeToProfileEdit(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workerHome_to_profileEdit)

    public fun actionWorkerHomeToCustomerSearch(): NavDirections =
        ActionOnlyNavDirections(R.id.action_workerHome_to_customerSearch)
  }
}
