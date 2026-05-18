package com.nammakelsa.ui.auth

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OtpVerificationFragmentArgs(
  public val verificationId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("verificationId", this.verificationId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("verificationId", this.verificationId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OtpVerificationFragmentArgs {
      bundle.setClassLoader(OtpVerificationFragmentArgs::class.java.classLoader)
      val __verificationId : String?
      if (bundle.containsKey("verificationId")) {
        __verificationId = bundle.getString("verificationId")
        if (__verificationId == null) {
          throw IllegalArgumentException("Argument \"verificationId\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"verificationId\" is missing and does not have an android:defaultValue")
      }
      return OtpVerificationFragmentArgs(__verificationId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        OtpVerificationFragmentArgs {
      val __verificationId : String?
      if (savedStateHandle.contains("verificationId")) {
        __verificationId = savedStateHandle["verificationId"]
        if (__verificationId == null) {
          throw IllegalArgumentException("Argument \"verificationId\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"verificationId\" is missing and does not have an android:defaultValue")
      }
      return OtpVerificationFragmentArgs(__verificationId)
    }
  }
}
