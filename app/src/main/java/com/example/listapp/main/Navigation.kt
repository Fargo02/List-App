package com.example.listapp.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.listapp.details.presentation.navigation.detailsScreen
import com.example.listapp.details.presentation.navigation.navigateToDetails
import com.example.listapp.home.presentation.navigation.HomeScreen
import com.example.listapp.home.presentation.navigation.homeScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen,
    ) {
        homeScreen(navigateToDetails = { navController.navigateToDetails() })

        detailsScreen(navigateBack = { navController.popBackStack() })
    }
}