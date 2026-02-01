package com.example.listapp.details.di

import com.example.listapp.details.domain.usecase.api.GetApkSha1UseCase
import com.example.listapp.details.domain.usecase.api.GetAppInfoByPackageUseCase
import com.example.listapp.details.domain.usecase.impl.GetApkSha1UseCaseImpl
import com.example.listapp.details.domain.usecase.impl.GetAppInfoByPackageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DetailsUseCaseModule {

    @Binds
    fun bindGetAppInfoByPackageUseCase(
        impl: GetAppInfoByPackageUseCaseImpl
    ): GetAppInfoByPackageUseCase

    @Binds
    fun bindGetApkSha1UseCase(
        impl: GetApkSha1UseCaseImpl
    ): GetApkSha1UseCase
}