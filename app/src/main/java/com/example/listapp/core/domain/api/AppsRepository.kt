package com.example.listapp.core.domain.api

import com.example.listapp.core.domain.model.InstalledApp

interface AppsRepository {

    suspend fun getAppsInfo(): List<InstalledApp>

    suspend fun getAppInfoByPackage(packageName: String): InstalledApp?
}