package com.example.listapp.core.domain.usecase.api

import com.example.listapp.core.domain.model.InstalledApp

interface GetAppInfoByPackageUseCase {

    suspend operator fun invoke(packageName: String): InstalledApp?
}