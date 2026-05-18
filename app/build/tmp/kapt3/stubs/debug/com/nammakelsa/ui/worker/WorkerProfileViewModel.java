package com.nammakelsa.ui.worker;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.GeoPoint;
import com.nammakelsa.data.model.ProfileFormState;
import com.nammakelsa.data.model.SkillType;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.data.model.ValidationResult;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
import com.nammakelsa.util.GeoHashUtil;
import com.nammakelsa.util.WorkerProfileValidator;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\rJ\b\u0010*\u001a\u00020\u0015H\u0002J\u0006\u0010+\u001a\u00020\u0015J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\rJ\u000e\u00100\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'J\u000e\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u000203R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/nammakelsa/ui/worker/WorkerProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "workerRepository", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "storageRepository", "Lcom/nammakelsa/domain/repository/StorageRepository;", "locationRepository", "Lcom/nammakelsa/domain/repository/LocationRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/nammakelsa/domain/repository/WorkerRepository;Lcom/nammakelsa/domain/repository/StorageRepository;Lcom/nammakelsa/domain/repository/LocationRepository;Lcom/google/firebase/auth/FirebaseAuth;)V", "_confirmationEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_formState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nammakelsa/data/model/ProfileFormState;", "_galleryState", "", "_saveState", "Lcom/nammakelsa/data/model/UiResult;", "", "confirmationEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getConfirmationEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "formState", "Lkotlinx/coroutines/flow/StateFlow;", "getFormState", "()Lkotlinx/coroutines/flow/StateFlow;", "galleryState", "getGalleryState", "saveState", "getSaveState", "uid", "getUid", "()Ljava/lang/String;", "addGalleryPhoto", "uri", "Landroid/net/Uri;", "deleteGalleryPhoto", "url", "loadProfile", "onSave", "updateDailyRate", "rate", "updateName", "name", "updateProfilePhotoUri", "updateSkillType", "skill", "Lcom/nammakelsa/data/model/SkillType;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class WorkerProfileViewModel extends androidx.lifecycle.ViewModel {
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
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> _saveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> saveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _galleryState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> galleryState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> _confirmationEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<java.lang.String> confirmationEvent = null;
    
    @javax.inject.Inject()
    public WorkerProfileViewModel(@org.jetbrains.annotations.NotNull()
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
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> getSaveState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getGalleryState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<java.lang.String> getConfirmationEvent() {
        return null;
    }
    
    private final java.lang.String getUid() {
        return null;
    }
    
    private final void loadProfile() {
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
    
    public final void onSave() {
    }
    
    public final void addGalleryPhoto(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    public final void deleteGalleryPhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
}