package com.nammakelsa.ui.customer

import android.os.Bundle
import androidx.navigation.NavDirections
import com.nammakelsa.R
import kotlin.Int
import kotlin.String

public class CustomerSearchFragmentDirections private constructor() {
  private data class ActionCustomerSearchToWorkerProfileView(
    public val workerId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_customerSearch_to_workerProfileView

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("workerId", this.workerId)
        return result
      }
  }

  public companion object {
    public fun actionCustomerSearchToWorkerProfileView(workerId: String): NavDirections =
        ActionCustomerSearchToWorkerProfileView(workerId)
  }
}
