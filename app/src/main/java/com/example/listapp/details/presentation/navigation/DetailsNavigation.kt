package com.example.listapp.details.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.listapp.details.presentation.DetailsRouter
import kotlinx.serialization.Serializable

@Serializable
data class DetailsScreen(val packageName: String)

fun NavController.navigateToDetails(packageName: String) {
    navigate(DetailsScreen(packageName)) {
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