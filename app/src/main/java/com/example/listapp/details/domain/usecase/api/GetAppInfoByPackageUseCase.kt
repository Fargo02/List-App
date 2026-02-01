package com.example.listapp.details.domain.usecase.api

import com.example.listapp.core.domain.model.InstalledApp

interface GetAppInfoByPackageUseCase {

    suspend operator fun invoke(packageName: String): InstalledApp?
}