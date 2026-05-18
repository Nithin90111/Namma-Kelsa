package com.nammakelsa.util;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class OtpLockoutManager_Factory implements Factory<OtpLockoutManager> {
  private final Provider<SharedPreferences> prefsProvider;

  public OtpLockoutManager_Factory(Provider<SharedPreferences> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public OtpLockoutManager get() {
    return newInstance(prefsProvider.get());
  }

  public static OtpLockoutManager_Factory create(Provider<SharedPreferences> prefsProvider) {
    return new OtpLockoutManager_Factory(prefsProvider);
  }

  public static OtpLockoutManager newInstance(SharedPreferences prefs) {
    return new OtpLockoutManager(prefs);
  }
}
