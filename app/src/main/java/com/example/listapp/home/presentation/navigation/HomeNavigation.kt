package com.example.listapp.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.listapp.home.presentation.HomeRouter
import kotlinx.serialization.Serializable

@Serializable
data object Home

fun NavGraphBuilder.homeScreen(
    navigateToDetails: (url: String) -> Unit
) {
    composable<Home> {
        HomeRouter(navigateToDetails = navigateToDetails)
    }
}