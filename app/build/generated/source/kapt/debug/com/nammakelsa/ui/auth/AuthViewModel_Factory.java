package com.nammakelsa.ui.auth;

import com.nammakelsa.domain.repository.AuthRepository;
import com.nammakelsa.util.OtpLockoutManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<OtpLockoutManager> otpLockoutManagerProvider;

  public AuthViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<OtpLockoutManager> otpLockoutManagerProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.otpLockoutManagerProvider = otpLockoutManagerProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(authRepositoryProvider.get(), otpLockoutManagerProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<OtpLockoutManager> otpLockoutManagerProvider) {
    return new AuthViewModel_Factory(authRepositoryProvider, otpLockoutManagerProvider);
  }

  public static AuthViewModel newInstance(AuthRepository authRepository,
      OtpLockoutManager otpLockoutManager) {
    return new AuthViewModel(authRepository, otpLockoutManager);
  }
}
