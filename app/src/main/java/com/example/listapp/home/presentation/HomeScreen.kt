package com.example.listapp.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(uiState.appList) {
                Text(text = it.name)
            }
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