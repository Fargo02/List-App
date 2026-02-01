package com.example.listapp.home.presentation.ui

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listapp.core.compose.AppIcon
import com.example.listapp.core.domain.model.InstalledApp
import com.example.listapp.ui.theme.ListAppTheme

@Composable
internal fun AppItem(
    item: InstalledApp,
    onClickToItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .combinedClickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClickToItem
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppIcon(
            drawable = item.icon,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = item.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun AppItemPreview() {
    ListAppTheme {
        AppItem(
            item = InstalledApp.empty(),
            onClickToItem = {}
        )
    }
}