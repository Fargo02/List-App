package com.example.listapp.core.compose

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.example.listapp.ui.theme.ListAppTheme

@Composable
fun AppIcon(
    drawable: Drawable?,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clip(RoundedCornerShape(8.dp))) {
        if (drawable != null) {
            val bitmap = drawable.toBitmap()
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "App icon",
                modifier = modifier
            )
        } else {
            Icon(
                painter = painterResource(id = android.R.drawable.sym_def_app_icon),
                contentDescription = "Placeholder",
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
private fun AppIconPreview() {
    ListAppTheme {
        AppIcon(
            modifier = Modifier.size(60.dp),
            drawable = null,
        )
    }
}