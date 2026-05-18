package com.nammakelsa.di;

import com.nammakelsa.data.repository.AuthRepositoryImpl;
import com.nammakelsa.data.repository.LocationRepositoryImpl;
import com.nammakelsa.data.repository.SearchRepositoryImpl;
import com.nammakelsa.data.repository.StorageRepositoryImpl;
import com.nammakelsa.data.repository.WorkerRepositoryImpl;
import com.nammakelsa.domain.repository.AuthRepository;
import com.nammakelsa.domain.repository.LocationRepository;
import com.nammakelsa.domain.repository.SearchRepository;
import com.nammakelsa.domain.repository.StorageRepository;
import com.nammakelsa.domain.repository.WorkerRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/nammakelsa/di/RepositoryModule;", "", "()V", "bindAuthRepository", "Lcom/nammakelsa/domain/repository/AuthRepository;", "impl", "Lcom/nammakelsa/data/repository/AuthRepositoryImpl;", "bindLocationRepository", "Lcom/nammakelsa/domain/repository/LocationRepository;", "Lcom/nammakelsa/data/repository/LocationRepositoryImpl;", "bindSearchRepository", "Lcom/nammakelsa/domain/repository/SearchRepository;", "Lcom/nammakelsa/data/repository/SearchRepositoryImpl;", "bindStorageRepository", "Lcom/nammakelsa/domain/repository/StorageRepository;", "Lcom/nammakelsa/data/repository/StorageRepositoryImpl;", "bindWorkerRepository", "Lcom/nammakelsa/domain/repository/WorkerRepository;", "Lcom/nammakelsa/data/repository/WorkerRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammakelsa.domain.repository.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.repository.AuthRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammakelsa.domain.repository.WorkerRepository bindWorkerRepository(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.repository.WorkerRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammakelsa.domain.repository.SearchRepository bindSearchRepository(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.repository.SearchRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammakelsa.domain.repository.StorageRepository bindStorageRepository(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.repository.StorageRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammakelsa.domain.repository.LocationRepository bindLocationRepository(@org.jetbrains.annotations.NotNull()
    com.nammakelsa.data.repository.LocationRepositoryImpl impl);
}