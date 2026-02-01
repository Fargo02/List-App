package com.example.listapp.core.domain.api

interface ExternalNavigator {

    fun launchTheApp(packageName: String)
}