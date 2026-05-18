package com.nammakelsa;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.nammakelsa.data.repository.AuthRepositoryImpl;
import com.nammakelsa.data.repository.LocationRepositoryImpl;
import com.nammakelsa.data.repository.SearchRepositoryImpl;
import com.nammakelsa.data.repository.StorageRepositoryImpl;
import com.nammakelsa.data.repository.WorkerRepositoryImpl;
import com.nammakelsa.di.AppModule_ProvideContextFactory;
import com.nammakelsa.di.AppModule_ProvideFirebaseAuthFactory;
import com.nammakelsa.di.AppModule_ProvideFirebaseFirestoreFactory;
import com.nammakelsa.di.AppModule_ProvideFirebaseStorageFactory;
import com.nammakelsa.di.AppModule_ProvideFusedLocationProviderClientFactory;
import com.nammakelsa.di.AppModule_ProvideSharedPreferencesFactory;
import com.nammakelsa.domain.repository.AuthRepository;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.SearchRepository;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
import com.nammakelsa.ui.MainActivity;
import com.nammakelsa.ui.MainActivity_MembersInjector;
import com.nammakelsa.ui.auth.AuthViewModel;
import com.nammakelsa.ui.auth.AuthViewModel_HiltModules;
import com.nammakelsa.ui.auth.OtpVerificationFragment;
import com.nammakelsa.ui.auth.PhoneEntryFragment;
import com.nammakelsa.ui.customer.CustomerSearchFragment;
import com.nammakelsa.ui.customer.SearchViewModel;
import com.nammakelsa.ui.customer.SearchViewModel_HiltModules;
import com.nammakelsa.ui.customer.WorkerProfileViewFragment;
import com.nammakelsa.ui.customer.WorkerProfileViewViewModel;
import com.nammakelsa.ui.customer.WorkerProfileViewViewModel_HiltModules;
import com.nammakelsa.ui.worker.RegistrationFragment;
import com.nammakelsa.ui.worker.RegistrationViewModel;
import com.nammakelsa.ui.worker.RegistrationViewModel_HiltModules;
import com.nammakelsa.ui.worker.WorkerHomeFragment;
import com.nammakelsa.ui.worker.WorkerHomeViewModel;
import com.nammakelsa.ui.worker.WorkerHomeViewModel_HiltModules;
import com.nammakelsa.ui.worker.WorkerProfileEditFragment;
import com.nammakelsa.ui.worker.WorkerProfileViewModel;
import com.nammakelsa.ui.worker.WorkerProfileViewModel_HiltModules;
import com.nammakelsa.util.OtpLockoutManager;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerNammaKelsaApp_HiltComponents_SingletonC {
  private DaggerNammaKelsaApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public NammaKelsaApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements NammaKelsaApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements NammaKelsaApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements NammaKelsaApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements NammaKelsaApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements NammaKelsaApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements NammaKelsaApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements NammaKelsaApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public NammaKelsaApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends NammaKelsaApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends NammaKelsaApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectOtpVerificationFragment(OtpVerificationFragment arg0) {
    }

    @Override
    public void injectPhoneEntryFragment(PhoneEntryFragment arg0) {
    }

    @Override
    public void injectCustomerSearchFragment(CustomerSearchFragment arg0) {
    }

    @Override
    public void injectWorkerProfileViewFragment(WorkerProfileViewFragment arg0) {
    }

    @Override
    public void injectRegistrationFragment(RegistrationFragment arg0) {
    }

    @Override
    public void injectWorkerHomeFragment(WorkerHomeFragment arg0) {
    }

    @Override
    public void injectWorkerProfileEditFragment(WorkerProfileEditFragment arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends NammaKelsaApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends NammaKelsaApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
      injectMainActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(6).put(LazyClassKeyProvider.com_nammakelsa_ui_auth_AuthViewModel, AuthViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_RegistrationViewModel, RegistrationViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nammakelsa_ui_customer_SearchViewModel, SearchViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_WorkerHomeViewModel, WorkerHomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_WorkerProfileViewModel, WorkerProfileViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_nammakelsa_ui_customer_WorkerProfileViewViewModel, WorkerProfileViewViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectFirebaseAuth(instance, singletonCImpl.provideFirebaseAuthProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_nammakelsa_ui_worker_WorkerHomeViewModel = "com.nammakelsa.ui.worker.WorkerHomeViewModel";

      static String com_nammakelsa_ui_worker_WorkerProfileViewModel = "com.nammakelsa.ui.worker.WorkerProfileViewModel";

      static String com_nammakelsa_ui_customer_WorkerProfileViewViewModel = "com.nammakelsa.ui.customer.WorkerProfileViewViewModel";

      static String com_nammakelsa_ui_auth_AuthViewModel = "com.nammakelsa.ui.auth.AuthViewModel";

      static String com_nammakelsa_ui_worker_RegistrationViewModel = "com.nammakelsa.ui.worker.RegistrationViewModel";

      static String com_nammakelsa_ui_customer_SearchViewModel = "com.nammakelsa.ui.customer.SearchViewModel";

      @KeepFieldType
      WorkerHomeViewModel com_nammakelsa_ui_worker_WorkerHomeViewModel2;

      @KeepFieldType
      WorkerProfileViewModel com_nammakelsa_ui_worker_WorkerProfileViewModel2;

      @KeepFieldType
      WorkerProfileViewViewModel com_nammakelsa_ui_customer_WorkerProfileViewViewModel2;

      @KeepFieldType
      AuthViewModel com_nammakelsa_ui_auth_AuthViewModel2;

      @KeepFieldType
      RegistrationViewModel com_nammakelsa_ui_worker_RegistrationViewModel2;

      @KeepFieldType
      SearchViewModel com_nammakelsa_ui_customer_SearchViewModel2;
    }
  }

  private static final class ViewModelCImpl extends NammaKelsaApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<RegistrationViewModel> registrationViewModelProvider;

    private Provider<SearchViewModel> searchViewModelProvider;

    private Provider<WorkerHomeViewModel> workerHomeViewModelProvider;

    private Provider<WorkerProfileViewModel> workerProfileViewModelProvider;

    private Provider<WorkerProfileViewViewModel> workerProfileViewViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.registrationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.searchViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.workerHomeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.workerProfileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.workerProfileViewViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(6).put(LazyClassKeyProvider.com_nammakelsa_ui_auth_AuthViewModel, ((Provider) authViewModelProvider)).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_RegistrationViewModel, ((Provider) registrationViewModelProvider)).put(LazyClassKeyProvider.com_nammakelsa_ui_customer_SearchViewModel, ((Provider) searchViewModelProvider)).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_WorkerHomeViewModel, ((Provider) workerHomeViewModelProvider)).put(LazyClassKeyProvider.com_nammakelsa_ui_worker_WorkerProfileViewModel, ((Provider) workerProfileViewModelProvider)).put(LazyClassKeyProvider.com_nammakelsa_ui_customer_WorkerProfileViewViewModel, ((Provider) workerProfileViewViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_nammakelsa_ui_worker_WorkerProfileViewModel = "com.nammakelsa.ui.worker.WorkerProfileViewModel";

      static String com_nammakelsa_ui_worker_RegistrationViewModel = "com.nammakelsa.ui.worker.RegistrationViewModel";

      static String com_nammakelsa_ui_auth_AuthViewModel = "com.nammakelsa.ui.auth.AuthViewModel";

      static String com_nammakelsa_ui_worker_WorkerHomeViewModel = "com.nammakelsa.ui.worker.WorkerHomeViewModel";

      static String com_nammakelsa_ui_customer_SearchViewModel = "com.nammakelsa.ui.customer.SearchViewModel";

      static String com_nammakelsa_ui_customer_WorkerProfileViewViewModel = "com.nammakelsa.ui.customer.WorkerProfileViewViewModel";

      @KeepFieldType
      WorkerProfileViewModel com_nammakelsa_ui_worker_WorkerProfileViewModel2;

      @KeepFieldType
      RegistrationViewModel com_nammakelsa_ui_worker_RegistrationViewModel2;

      @KeepFieldType
      AuthViewModel com_nammakelsa_ui_auth_AuthViewModel2;

      @KeepFieldType
      WorkerHomeViewModel com_nammakelsa_ui_worker_WorkerHomeViewModel2;

      @KeepFieldType
      SearchViewModel com_nammakelsa_ui_customer_SearchViewModel2;

      @KeepFieldType
      WorkerProfileViewViewModel com_nammakelsa_ui_customer_WorkerProfileViewViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.nammakelsa.ui.auth.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.bindAuthRepositoryProvider.get(), singletonCImpl.otpLockoutManagerProvider.get());

          case 1: // com.nammakelsa.ui.worker.RegistrationViewModel 
          return (T) new RegistrationViewModel(singletonCImpl.bindWorkerRepositoryProvider.get(), singletonCImpl.bindStorageRepositoryProvider.get(), singletonCImpl.bindLocationRepositoryProvider.get(), singletonCImpl.provideFirebaseAuthProvider.get());

          case 2: // com.nammakelsa.ui.customer.SearchViewModel 
          return (T) new SearchViewModel(singletonCImpl.bindSearchRepositoryProvider.get(), singletonCImpl.bindLocationRepositoryProvider.get());

          case 3: // com.nammakelsa.ui.worker.WorkerHomeViewModel 
          return (T) new WorkerHomeViewModel(singletonCImpl.bindWorkerRepositoryProvider.get(), singletonCImpl.provideFirebaseAuthProvider.get());

          case 4: // com.nammakelsa.ui.worker.WorkerProfileViewModel 
          return (T) new WorkerProfileViewModel(singletonCImpl.bindWorkerRepositoryProvider.get(), singletonCImpl.bindStorageRepositoryProvider.get(), singletonCImpl.bindLocationRepositoryProvider.get(), singletonCImpl.provideFirebaseAuthProvider.get());

          case 5: // com.nammakelsa.ui.customer.WorkerProfileViewViewModel 
          return (T) new WorkerProfileViewViewModel(singletonCImpl.bindWorkerRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends NammaKelsaApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends NammaKelsaApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends NammaKelsaApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

    private Provider<AuthRepository> bindAuthRepositoryProvider;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<OtpLockoutManager> otpLockoutManagerProvider;

    private Provider<FirebaseFirestore> provideFirebaseFirestoreProvider;

    private Provider<FirebaseStorage> provideFirebaseStorageProvider;

    private Provider<StorageRepositoryImpl> storageRepositoryImplProvider;

    private Provider<StorageRepository> bindStorageRepositoryProvider;

    private Provider<WorkerRepositoryImpl> workerRepositoryImplProvider;

    private Provider<WorkerRepository> bindWorkerRepositoryProvider;

    private Provider<FusedLocationProviderClient> provideFusedLocationProviderClientProvider;

    private Provider<LocationRepositoryImpl> locationRepositoryImplProvider;

    private Provider<LocationRepository> bindLocationRepositoryProvider;

    private Provider<SearchRepositoryImpl> searchRepositoryImplProvider;

    private Provider<SearchRepository> bindSearchRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private Context context() {
      return AppModule_ProvideContextFactory.provideContext(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideFirebaseAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 0));
      this.authRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 1);
      this.bindAuthRepositoryProvider = DoubleCheck.provider((Provider) authRepositoryImplProvider);
      this.provideSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences>(singletonCImpl, 3));
      this.otpLockoutManagerProvider = DoubleCheck.provider(new SwitchingProvider<OtpLockoutManager>(singletonCImpl, 2));
      this.provideFirebaseFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 5));
      this.provideFirebaseStorageProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseStorage>(singletonCImpl, 7));
      this.storageRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 6);
      this.bindStorageRepositoryProvider = DoubleCheck.provider((Provider) storageRepositoryImplProvider);
      this.workerRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 4);
      this.bindWorkerRepositoryProvider = DoubleCheck.provider((Provider) workerRepositoryImplProvider);
      this.provideFusedLocationProviderClientProvider = DoubleCheck.provider(new SwitchingProvider<FusedLocationProviderClient>(singletonCImpl, 9));
      this.locationRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 8);
      this.bindLocationRepositoryProvider = DoubleCheck.provider((Provider) locationRepositoryImplProvider);
      this.searchRepositoryImplProvider = new SwitchingProvider<>(singletonCImpl, 10);
      this.bindSearchRepositoryProvider = DoubleCheck.provider((Provider) searchRepositoryImplProvider);
    }

    @Override
    public void injectNammaKelsaApp(NammaKelsaApp arg0) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.google.firebase.auth.FirebaseAuth 
          return (T) AppModule_ProvideFirebaseAuthFactory.provideFirebaseAuth();

          case 1: // com.nammakelsa.data.repository.AuthRepositoryImpl 
          return (T) new AuthRepositoryImpl(singletonCImpl.provideFirebaseAuthProvider.get());

          case 2: // com.nammakelsa.util.OtpLockoutManager 
          return (T) new OtpLockoutManager(singletonCImpl.provideSharedPreferencesProvider.get());

          case 3: // android.content.SharedPreferences 
          return (T) AppModule_ProvideSharedPreferencesFactory.provideSharedPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.nammakelsa.data.repository.WorkerRepositoryImpl 
          return (T) new WorkerRepositoryImpl(singletonCImpl.provideFirebaseFirestoreProvider.get(), singletonCImpl.bindStorageRepositoryProvider.get());

          case 5: // com.google.firebase.firestore.FirebaseFirestore 
          return (T) AppModule_ProvideFirebaseFirestoreFactory.provideFirebaseFirestore();

          case 6: // com.nammakelsa.data.repository.StorageRepositoryImpl 
          return (T) new StorageRepositoryImpl(singletonCImpl.provideFirebaseStorageProvider.get());

          case 7: // com.google.firebase.storage.FirebaseStorage 
          return (T) AppModule_ProvideFirebaseStorageFactory.provideFirebaseStorage();

          case 8: // com.nammakelsa.data.repository.LocationRepositoryImpl 
          return (T) new LocationRepositoryImpl(singletonCImpl.provideFusedLocationProviderClientProvider.get(), singletonCImpl.context());

          case 9: // com.google.android.gms.location.FusedLocationProviderClient 
          return (T) AppModule_ProvideFusedLocationProviderClientFactory.provideFusedLocationProviderClient(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 10: // com.nammakelsa.data.repository.SearchRepositoryImpl 
          return (T) new SearchRepositoryImpl(singletonCImpl.provideFirebaseFirestoreProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
