package com.example.listapp.details.domain.usecase.impl

import com.example.listapp.core.domain.api.AppsRepository
import com.example.listapp.core.domain.model.InstalledApp
import com.example.listapp.details.domain.usecase.api.GetAppInfoByPackageUseCase
import javax.inject.Inject

class GetAppInfoByPackageUseCaseImpl @Inject constructor(
    private val appsRepository: AppsRepository
): GetAppInfoByPackageUseCase {

    override suspend fun invoke(packageName: String): InstalledApp? {
        return appsRepository.getAppInfoByPackage(packageName)
    }
}