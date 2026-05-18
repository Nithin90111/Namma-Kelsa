package com.nammakelsa.data.repository;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
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
public final class LocationRepositoryImpl_Factory implements Factory<LocationRepositoryImpl> {
  private final Provider<FusedLocationProviderClient> fusedLocationClientProvider;

  private final Provider<Context> contextProvider;

  public LocationRepositoryImpl_Factory(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<Context> contextProvider) {
    this.fusedLocationClientProvider = fusedLocationClientProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public LocationRepositoryImpl get() {
    return newInstance(fusedLocationClientProvider.get(), contextProvider.get());
  }

  public static LocationRepositoryImpl_Factory create(
      Provider<FusedLocationProviderClient> fusedLocationClientProvider,
      Provider<Context> contextProvider) {
    return new LocationRepositoryImpl_Factory(fusedLocationClientProvider, contextProvider);
  }

  public static LocationRepositoryImpl newInstance(FusedLocationProviderClient fusedLocationClient,
      Context context) {
    return new LocationRepositoryImpl(fusedLocationClient, context);
  }
}
