package com.nammakelsa.data.repository;

import android.net.Uri;
import com.google.firebase.storage.FirebaseStorage;
import com.nammakelsa.domain.repository.StorageRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/nammakelsa/data/repository/StorageRepositoryImpl;", "Lcom/nammakelsa/domain/repository/StorageRepository;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "deleteImage", "Lkotlin/Result;", "", "url", "", "deleteImage-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "path", "imageUri", "Landroid/net/Uri;", "uploadImage-0E7RQCE", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class StorageRepositoryImpl implements com.nammakelsa.domain.repository.StorageRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    
    @javax.inject.Inject()
    public StorageRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage storage) {
        super();
    }
}