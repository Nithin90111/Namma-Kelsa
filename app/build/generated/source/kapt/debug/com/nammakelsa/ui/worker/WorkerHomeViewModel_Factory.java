package com.nammakelsa.ui.worker;

import com.google.firebase.auth.FirebaseAuth;
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
public final class WorkerHomeViewModel_Factory implements Factory<WorkerHomeViewModel> {
  private final Provider<WorkerRepository> workerRepositoryProvider;

  private final Provider<FirebaseAuth> firebaseAuthProvider;

  public WorkerHomeViewModel_Factory(Provider<WorkerRepository> workerRepositoryProvider,
      Provider<FirebaseAuth> firebaseAuthProvider) {
    this.workerRepositoryProvider = workerRepositoryProvider;
    this.firebaseAuthProvider = firebaseAuthProvider;
  }

  @Override
  public WorkerHomeViewModel get() {
    return newInstance(workerRepositoryProvider.get(), firebaseAuthProvider.get());
  }

  public static WorkerHomeViewModel_Factory create(
      Provider<WorkerRepository> workerRepositoryProvider,
      Provider<FirebaseAuth> firebaseAuthProvider) {
    return new WorkerHomeViewModel_Factory(workerRepositoryProvider, firebaseAuthProvider);
  }

  public static WorkerHomeViewModel newInstance(WorkerRepository workerRepository,
      FirebaseAuth firebaseAuth) {
    return new WorkerHomeViewModel(workerRepository, firebaseAuth);
  }
}
