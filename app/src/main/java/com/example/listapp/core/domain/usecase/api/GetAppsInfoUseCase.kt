package com.example.listapp.core.domain.usecase.api

import com.example.listapp.core.domain.model.InstalledApp

interface GetAppsInfoUseCase {

    suspend operator fun invoke(): List<InstalledApp>
}