package com.example.listapp.home.presentation.state

import com.example.listapp.core.domain.model.InstalledApp

data class HomeState(
    val appList: List<InstalledApp> = emptyList()
)
