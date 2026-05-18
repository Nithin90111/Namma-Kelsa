package com.nammakelsa.ui.customer;

import androidx.lifecycle.ViewModel;
import com.nammakelsa.data.model.UiResult;
import com.nammakelsa.data.model.WorkerProfile;
import com.nammakelsa.domain.repository.WorkerRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/nammakelsa/ui/customer/WorkerProfileViewViewModel;", "Landroidx/lifecycle/ViewModel;", "workerRepository", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "(Lcom/nammakelsa/domain/repository/WorkerRepository;)V", "_dialerEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_profileState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/nammakelsa/data/model/UiResult;", "Lcom/nammakelsa/data/model/WorkerProfile;", "dialerEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getDialerEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "profileState", "Lkotlinx/coroutines/flow/StateFlow;", "getProfileState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadProfile", "", "workerId", "onCallClicked", "phoneNumber", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class WorkerProfileViewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.WorkerRepository workerRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.nammakelsa.data.model.UiResult<com.nammakelsa.data.model.WorkerProfile>> _profileState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<com.nammakelsa.data.model.WorkerProfile>> profileState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> _dialerEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<java.lang.String> dialerEvent = null;
    
    @javax.inject.Inject()
    public WorkerProfileViewViewModel(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.WorkerRepository workerRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.nammakelsa.data.model.UiResult<com.nammakelsa.data.model.WorkerProfile>> getProfileState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<java.lang.String> getDialerEvent() {
        return null;
    }
    
    public final void loadProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String workerId) {
    }
    
    /**
     * Emits the worker's phone number as a one-shot event.
     * The fragment observes this and fires an ACTION_DIAL intent.
     *
     * Property 11: Call button launches dialer with correct phone number.
     * Validates: Requirements 5.3
     */
    public final void onCallClicked(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber) {
    }
}