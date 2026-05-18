package com.nammakelsa.ui.auth

import android.os.Bundle
import androidx.navigation.NavDirections
import com.nammakelsa.R
import kotlin.Int
import kotlin.String

public class PhoneEntryFragmentDirections private constructor() {
  private data class ActionPhoneEntryToOtpVerification(
    public val verificationId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_phoneEntry_to_otpVerification

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("verificationId", this.verificationId)
        return result
      }
  }

  public companion object {
    public fun actionPhoneEntryToOtpVerification(verificationId: String): NavDirections =
        ActionPhoneEntryToOtpVerification(verificationId)
  }
}
