package com.example.listapp.details.presentation.state

import com.example.listapp.core.domain.model.InstalledApp

data class DetailsState(
    val appInfo: InstalledApp? = null,
    val checksum: String = ""
)