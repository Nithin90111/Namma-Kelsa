package com.nammakelsa.ui.worker;

import androidx.lifecycle.ViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.data.model.WorkerProfile;
import com.nammakelsa.domain.repository.WorkerRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aR\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/nammakelsa/ui/worker/WorkerHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "workerRepository", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "(Lcom/nammakelsa/domain/repository/WorkerRepository;Lcom/google/firebase/auth/FirebaseAuth;)V", "_availabilityState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nammakelsa/data/model/UiResult;", "", "_profileState", "Lcom/nammakelsa/data/model/WorkerProfile;", "availabilityState", "Lkotlinx/coroutines/flow/StateFlow;", "getAvailabilityState", "()Lkotlinx/coroutines/flow/StateFlow;", "profileState", "getProfileState", "uid", "", "getUid", "()Ljava/lang/String;", "observeProfile", "setAvailability", "available", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class WorkerHomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.WorkerRepository workerRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.WorkerProfile> _profileState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.WorkerProfile> profileState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> _availabilityState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> availabilityState = null;
    
    @javax.inject.Inject()
    public WorkerHomeViewModel(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.WorkerRepository workerRepository, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.WorkerProfile> getProfileState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<kotlin.Unit>> getAvailabilityState() {
        return null;
    }
    
    private final java.lang.String getUid() {
        return null;
    }
    
    private final void observeProfile() {
    }
    
    public final void setAvailability(boolean available) {
    }
}