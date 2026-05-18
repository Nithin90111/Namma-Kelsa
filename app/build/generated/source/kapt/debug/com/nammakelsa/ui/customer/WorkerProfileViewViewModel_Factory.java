package com.nammakelsa.ui.customer;

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
public final class WorkerProfileViewViewModel_Factory implements Factory<WorkerProfileViewViewModel> {
  private final Provider<WorkerRepository> workerRepositoryProvider;

  public WorkerProfileViewViewModel_Factory(Provider<WorkerRepository> workerRepositoryProvider) {
    this.workerRepositoryProvider = workerRepositoryProvider;
  }

  @Override
  public WorkerProfileViewViewModel get() {
    return newInstance(workerRepositoryProvider.get());
  }

  public static WorkerProfileViewViewModel_Factory create(
      Provider<WorkerRepository> workerRepositoryProvider) {
    return new WorkerProfileViewViewModel_Factory(workerRepositoryProvider);
  }

  public static WorkerProfileViewViewModel newInstance(WorkerRepository workerRepository) {
    return new WorkerProfileViewViewModel(workerRepository);
  }
}
