package com.nammakelsa.ui.customer

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class WorkerProfileViewFragmentArgs(
  public val workerId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("workerId", this.workerId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("workerId", this.workerId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): WorkerProfileViewFragmentArgs {
      bundle.setClassLoader(WorkerProfileViewFragmentArgs::class.java.classLoader)
      val __workerId : String?
      if (bundle.containsKey("workerId")) {
        __workerId = bundle.getString("workerId")
        if (__workerId == null) {
          throw IllegalArgumentException("Argument \"workerId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"workerId\" is missing and does not have an android:defaultValue")
      }
      return WorkerProfileViewFragmentArgs(__workerId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        WorkerProfileViewFragmentArgs {
      val __workerId : String?
      if (savedStateHandle.contains("workerId")) {
        __workerId = savedStateHandle["workerId"]
        if (__workerId == null) {
          throw IllegalArgumentException("Argument \"workerId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"workerId\" is missing and does not have an android:defaultValue")
      }
      return WorkerProfileViewFragmentArgs(__workerId)
    }
  }
}
