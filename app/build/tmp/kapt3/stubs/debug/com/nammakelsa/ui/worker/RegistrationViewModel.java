package com.nammakelsa.ui.worker;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.GeoPoint;
import com.nammakelsa.data.model.ProfileFormState;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.data.model.ValidationResult;
import com.nammakelsa.data.model.WorkerProfile;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
import com.nammakelsa.util.GeoHashUtil;
import com.nammakelsa.util.WorkerProfileValidator;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/nammakelsa/ui/worker/RegistrationViewModel;", "Landroidx/lifecycle/ViewModel;", "workerRepository", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "storageRepository", "Lcom/nammakelsa/domain/repository/StorageRepository;", "locationRepository", "Lcom/nammakelsa/domain/repository/LocationRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/nammakelsa/domain/repository/WorkerRepository;Lcom/nammakelsa/domain/repository/StorageRepository;Lcom/nammakelsa/domain/repository/LocationRepository;Lcom/google/firebase/auth/FirebaseAuth;)V", "_formState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nammakelsa/data/model/ProfileFormState;", "_registrationState", "Lcom/nammakelsa/data/model/UiResult;", "", "formState", "Lkotlinx/coroutines/flow/StateFlow;", "getFormState", "()Lkotlinx/coroutines/flow/StateFlow;", "registrationState", "getRegistrationState", "onSubmit", "updateDailyRate", "rate", "", "updateName", "name", "updateProfilePhotoUri", "uri", "Landroid/net/Uri;", "updateSkillType", "skill", "Lcom/nammakelsa/data/model/SkillType;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RegistrationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.WorkerRepository workerRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.StorageRepository storageRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.LocationRepository locationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.ProfileFormState> _formState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.ProfileFormState> formState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> _registrationState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> registrationState = null;
    
    @javax.inject.Inject()
    public RegistrationViewModel(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.WorkerRepository workerRepository, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.StorageRepository storageRepository, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.LocationRepository locationRepository, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.ProfileFormState> getFormState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> getRegistrationState() {
        return null;
    }
    
    public final void updateName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void updateSkillType(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.model.SkillType skill) {
    }
    
    public final void updateDailyRate(@org.jetbrains.annotations.NotNull()
    java.lang.String rate) {
    }
    
    public final void updateProfilePhotoUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    public final void onSubmit() {
    }
}