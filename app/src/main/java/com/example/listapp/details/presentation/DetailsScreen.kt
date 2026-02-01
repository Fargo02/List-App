package com.example.listapp.details.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listapp.R
import com.example.listapp.core.compose.AppIcon
import com.example.listapp.details.presentation.state.DetailsAction
import com.example.listapp.details.presentation.state.DetailsState
import com.example.listapp.details.presentation.ui.DetailsTopAppBar
import com.example.listapp.ui.theme.ListAppTheme

@Composable
internal fun DetailsScreen(
    uiState: DetailsState,
    onAction: (DetailsAction) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { DetailsTopAppBar(navigateBack) }
    ) { paddingValue ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AppIcon(
                drawable = uiState.appInfo?.icon,
                modifier = Modifier.size(60.dp)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = uiState.appInfo?.name ?: "",
                fontSize = 24.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.version, uiState.appInfo?.versionName ?: ""),
                fontSize = 16.sp
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = uiState.appInfo?.packageName ?: "",
                fontSize = 16.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = uiState.checksum,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { onAction(DetailsAction.LaunchApp) }
            ) {
                Text(text = stringResource(R.string.open_the_app))
            }
        }
    }
}

@Preview
@Composable
private fun DetailsScreenPreview() {
    ListAppTheme {
        DetailsScreen(
            uiState = DetailsState(),
            onAction = {},
            navigateBack = {}
        )
    }
}