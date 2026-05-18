package com.nammakelsa.di

import com.nammakelsa.data.repository.AuthRepositoryImpl
import com.nammakelsa.data.repository.LocationRepositoryImpl
import com.nammakelsa.data.repository.SearchRepositoryImpl
import com.nammakelsa.data.repository.StorageRepositoryImpl
import com.nammakelsa.data.repository.WorkerRepositoryImpl
import com.nammakelsa.domain.repository.AuthRepository
import com.nammakelsa.domain.repository.LocationRepository
import com.nammakelsa.domain.repository.SearchRepository
import com.nammakelsa.domain.repository.StorageRepository
import com.nammakelsa.domain.repository.WorkerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindWorkerRepository(impl: WorkerRepositoryImpl): WorkerRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    @Binds
    @Singleton
    abstract fun bindStorageRepository(impl: StorageRepositoryImpl): StorageRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(impl: LocationRepositoryImpl): LocationRepository
}
