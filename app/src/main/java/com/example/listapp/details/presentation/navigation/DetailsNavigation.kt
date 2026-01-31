package com.example.listapp.details.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.listapp.details.presentation.DetailsRouter
import kotlinx.serialization.Serializable

@Serializable
data object DetailsScreen

fun NavController.navigateToDetails() {
    navigate(DetailsScreen) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.detailsScreen(
    navigateBack: () -> Unit
) {
    composable<DetailsScreen> {
        DetailsRouter(
            navigateBack = navigateBack
        )
    }
}