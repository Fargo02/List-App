package com.example.listapp.details.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailsRouter(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel<DetailsViewModel>()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailsScreen(
        modifier = modifier,
        uiState = uiState,
        navigateBack = navigateBack
    )
}