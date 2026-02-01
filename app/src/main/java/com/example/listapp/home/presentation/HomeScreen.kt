package com.example.listapp.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listapp.home.presentation.state.HomeState
import com.example.listapp.home.presentation.ui.AppItem
import com.example.listapp.ui.theme.ListAppTheme

@Composable
internal fun HomeScreen(
    uiState: HomeState,
    navigateToDetails: (packageName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValue ->
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = paddingValue.calculateTopPadding() + 16.dp,
                bottom = paddingValue.calculateBottomPadding() + 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.appList) {
                AppItem(
                    item = it,
                    onClickToItem = { navigateToDetails(it.packageName) }
                )
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