package com.example.listapp.details.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listapp.R
import com.example.listapp.ui.theme.ListAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailsTopAppBar(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = stringResource(R.string.about_app),
                color = colorScheme.onBackground,
                fontWeight = FontWeight(400),
                fontSize = 20.sp,
                lineHeight = 26.sp
            )
        },
        navigationIcon = {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable(onClick = navigateBack),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = colorScheme.onBackground
                )
            }
        }
    )
}

@Preview
@Composable
private fun DetailsTopAppBarPreview() {
    ListAppTheme {
        DetailsTopAppBar(
            navigateBack = {}
        )
    }
}