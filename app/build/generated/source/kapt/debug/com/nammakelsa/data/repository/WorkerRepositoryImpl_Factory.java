package com.nammakelsa.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.nammakelsa.domain.repository.StorageRepository;
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
public final class WorkerRepositoryImpl_Factory implements Factory<WorkerRepositoryImpl> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<StorageRepository> storageRepositoryProvider;

  public WorkerRepositoryImpl_Factory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    this.firestoreProvider = firestoreProvider;
    this.storageRepositoryProvider = storageRepositoryProvider;
  }

  @Override
  public WorkerRepositoryImpl get() {
    return newInstance(firestoreProvider.get(), storageRepositoryProvider.get());
  }

  public static WorkerRepositoryImpl_Factory create(Provider<FirebaseFirestore> firestoreProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    return new WorkerRepositoryImpl_Factory(firestoreProvider, storageRepositoryProvider);
  }

  public static WorkerRepositoryImpl newInstance(FirebaseFirestore firestore,
      StorageRepository storageRepository) {
    return new WorkerRepositoryImpl(firestore, storageRepository);
  }
}
