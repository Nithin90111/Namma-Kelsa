package com.nammakelsa.domain.repository;

import android.net.Uri;
import com.nammakelsa.data.model.WorkerProfile;
import kotlinx.coroutines.flow.Flow;

/**
 * Abstraction over Firestore and Storage operations for worker profiles.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\u0005\u001a\u00020\u0004H&J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ8\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010 H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"Lcom/nammakelsa/domain/repository/WorkerRepository;", "", "addGalleryPhoto", "Lkotlin/Result;", "", "workerId", "imageUri", "Landroid/net/Uri;", "addGalleryPhoto-0E7RQCE", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createProfile", "", "profile", "Lcom/nammakelsa/data/model/WorkerProfile;", "createProfile-gIAlu-s", "(Lcom/nammakelsa/data/model/WorkerProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGalleryPhoto", "photoUrl", "deleteGalleryPhoto-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfile", "getProfile-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeProfile", "Lkotlinx/coroutines/flow/Flow;", "setAvailability", "available", "", "setAvailability-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProfile", "updates", "", "updateProfile-0E7RQCE", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface WorkerRepository {
    
    /**
     * Returns a [Flow] that emits the latest [WorkerProfile] whenever the Firestore
     * document for [workerId] changes.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nammakelsa.data.model.WorkerProfile> observeProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String workerId);
}