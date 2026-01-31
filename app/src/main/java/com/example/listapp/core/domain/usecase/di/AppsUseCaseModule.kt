package com.example.listapp.core.domain.usecase.di

import com.example.listapp.core.domain.usecase.api.GetAppInfoByPackageUseCase
import com.example.listapp.core.domain.usecase.api.GetAppsInfoUseCase
import com.example.listapp.core.domain.usecase.impl.GetAppInfoByPackageUseCaseImpl
import com.example.listapp.core.domain.usecase.impl.GetAppsInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppsUseCaseModule {

    @Binds
    fun bindGetAppsInfoUseCase(
        impl: GetAppsInfoUseCaseImpl
    ): GetAppsInfoUseCase

    @Binds
    fun bindGetAppInfoByPackageUseCase(
        impl: GetAppInfoByPackageUseCaseImpl
    ): GetAppInfoByPackageUseCase
}