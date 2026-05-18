package com.nammakelsa.ui.customer;

import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.SearchRepository;
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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<SearchRepository> searchRepositoryProvider;

  private final Provider<LocationRepository> locationRepositoryProvider;

  public SearchViewModel_Factory(Provider<SearchRepository> searchRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider) {
    this.searchRepositoryProvider = searchRepositoryProvider;
    this.locationRepositoryProvider = locationRepositoryProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(searchRepositoryProvider.get(), locationRepositoryProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<SearchRepository> searchRepositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider) {
    return new SearchViewModel_Factory(searchRepositoryProvider, locationRepositoryProvider);
  }

  public static SearchViewModel newInstance(SearchRepository searchRepository,
      LocationRepository locationRepository) {
    return new SearchViewModel(searchRepository, locationRepository);
  }
}
