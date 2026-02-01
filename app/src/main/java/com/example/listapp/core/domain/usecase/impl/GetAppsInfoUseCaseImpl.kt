package com.example.listapp.core.domain.usecase.impl

import com.example.listapp.core.domain.api.AppsRepository
import com.example.listapp.core.domain.model.InstalledApp
import com.example.listapp.core.domain.usecase.api.GetAppsInfoUseCase
import javax.inject.Inject

class GetAppsInfoUseCaseImpl @Inject constructor(
    private val appsRepository: AppsRepository
): GetAppsInfoUseCase {

    override suspend fun invoke(): List<InstalledApp> {
        return appsRepository.getAppsInfo()
    }
}