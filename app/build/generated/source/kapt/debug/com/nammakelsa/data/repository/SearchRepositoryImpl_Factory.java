package com.nammakelsa.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
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
public final class SearchRepositoryImpl_Factory implements Factory<SearchRepositoryImpl> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public SearchRepositoryImpl_Factory(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public SearchRepositoryImpl get() {
    return newInstance(firestoreProvider.get());
  }

  public static SearchRepositoryImpl_Factory create(Provider<FirebaseFirestore> firestoreProvider) {
    return new SearchRepositoryImpl_Factory(firestoreProvider);
  }

  public static SearchRepositoryImpl newInstance(FirebaseFirestore firestore) {
    return new SearchRepositoryImpl(firestore);
  }
}
