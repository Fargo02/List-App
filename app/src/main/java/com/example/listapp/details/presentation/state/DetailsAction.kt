package com.example.listapp.details.presentation.state

sealed interface DetailsAction {

    data object LaunchApp : DetailsAction
}