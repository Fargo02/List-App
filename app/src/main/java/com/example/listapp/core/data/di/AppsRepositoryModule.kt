package com.example.listapp.core.data.di

import com.example.listapp.core.data.repository.AppsRepositoryImpl
import com.example.listapp.core.data.repository.ExternalNavigatorImpl
import com.example.listapp.core.domain.api.AppsRepository
import com.example.listapp.core.domain.api.ExternalNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppsRepositoryModule {

    @Binds
    fun bindAppsRepository(
        impl: AppsRepositoryImpl
    ): AppsRepository

    @Binds
    fun bindExternalNavigator(
        impl: ExternalNavigatorImpl
    ): ExternalNavigator
}