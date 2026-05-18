package com.nammakelsa.data.repository;

import android.net.Uri;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nammakelsa.data.model.WorkerProfile;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\n\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\"J8\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020&0%H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\'\u0010(J\b\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006+"}, d2 = {"Lcom/nammakelsa/data/repository/WorkerRepositoryImpl;", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "storageRepository", "Lcom/nammakelsa/domain/repository/StorageRepository;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/nammakelsa/domain/repository/StorageRepository;)V", "addGalleryPhoto", "Lkotlin/Result;", "", "workerId", "imageUri", "Landroid/net/Uri;", "addGalleryPhoto-0E7RQCE", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createProfile", "", "profile", "Lcom/nammakelsa/data/model/WorkerProfile;", "createProfile-gIAlu-s", "(Lcom/nammakelsa/data/model/WorkerProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGalleryPhoto", "photoUrl", "deleteGalleryPhoto-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfile", "getProfile-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeProfile", "Lkotlinx/coroutines/flow/Flow;", "setAvailability", "available", "", "setAvailability-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProfile", "updates", "", "", "updateProfile-0E7RQCE", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "workersCollection", "Lcom/google/firebase/firestore/CollectionReference;", "app_debug"})
public final class WorkerRepositoryImpl implements com.nammakelsa.domain.repository.WorkerRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammakelsa.domain.repository.StorageRepository storageRepository = null;
    
    @javax.inject.Inject()
    public WorkerRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.nammakelsa.domain.repository.StorageRepository storageRepository) {
        super();
    }
    
    private final com.google.firebase.firestore.CollectionReference workersCollection() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.nammakelsa.data.model.WorkerProfile> observeProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String workerId) {
        return null;
    }
}