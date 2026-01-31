package com.example.listapp.core.domain.model

import android.graphics.drawable.Drawable

data class InstalledApp(
    val name: String,
    val packageName: String,
    val versionName: String,
    val icon: Drawable?
) {
    companion object {
        fun empty() = InstalledApp(
            name = "Test app",
            packageName = "",
            versionName = "1.0.0",
            icon = null
        )
    }
}