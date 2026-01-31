package com.example.listapp.details.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listapp.details.presentation.state.DetailsState
import com.example.listapp.ui.theme.ListAppTheme

@Composable
internal fun DetailsScreen(
    uiState: DetailsState,
    navigateBack: () -> Unit,
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
private fun DetailsScreenPreview() {
    ListAppTheme {
        DetailsScreen(
            uiState = DetailsState(),
            navigateBack = {}
        )
    }
}