package com.example.listapp.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listapp.home.presentation.state.HomeState
import com.example.listapp.ui.theme.ListAppTheme

@Composable
internal fun HomeScreen(
    uiState: HomeState,
    navigateToDetails: (url: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValue ->
        Column(
            modifier = modifier.padding(paddingValue)
        ) {

        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    ListAppTheme {
        HomeScreen(
            uiState = HomeState(),
            navigateToDetails = {}
        )
    }
}