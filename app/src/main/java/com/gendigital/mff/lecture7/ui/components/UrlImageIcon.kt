package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gendigital.mff.lecture7.R

/**
 * Icon of maximum width 128dp loaded from [url].
 */
@Composable
fun UrlImageIcon(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier.widthIn(0.dp, 128.dp)
    )
}
