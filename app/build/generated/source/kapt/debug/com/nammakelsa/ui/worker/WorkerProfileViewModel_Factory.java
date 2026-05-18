package com.nammakelsa.ui.worker;

import com.google.firebase.auth.FirebaseAuth;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
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
public final class WorkerProfileViewModel_Factory implements Factory<WorkerProfileViewModel> {
  private final Provider<WorkerRepository> workerRepositoryProvider;

  private final Provider<StorageRepository> storageRepositoryProvider;

  private final Provider<LocationRepository> locationRepositoryProvider;

  private final Provider<FirebaseAuth> firebaseAuthProvider;

  public WorkerProfileViewModel_Factory(Provider<WorkerRepository> workerRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider,
      Provider<FirebaseAuth> firebaseAuthProvider) {
    this.workerRepositoryProvider = workerRepositoryProvider;
    this.storageRepositoryProvider = storageRepositoryProvider;
    this.locationRepositoryProvider = locationRepositoryProvider;
    this.firebaseAuthProvider = firebaseAuthProvider;
  }

  @Override
  public WorkerProfileViewModel get() {
    return newInstance(workerRepositoryProvider.get(), storageRepositoryProvider.get(), locationRepositoryProvider.get(), firebaseAuthProvider.get());
  }

  public static WorkerProfileViewModel_Factory create(
      Provider<WorkerRepository> workerRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider,
      Provider<FirebaseAuth> firebaseAuthProvider) {
    return new WorkerProfileViewModel_Factory(workerRepositoryProvider, storageRepositoryProvider, locationRepositoryProvider, firebaseAuthProvider);
  }

  public static WorkerProfileViewModel newInstance(WorkerRepository workerRepository,
      StorageRepository storageRepository, LocationRepository locationRepository,
      FirebaseAuth firebaseAuth) {
    return new WorkerProfileViewModel(workerRepository, storageRepository, locationRepository, firebaseAuth);
  }
}
