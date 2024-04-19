package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle

/**
 * Simple clickable text containing link.
 */
@Composable
fun ClickableLink(url: String) {
    val localUriHandler = LocalUriHandler.current

    ClickableText(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.DarkGray,
                    textDecoration = TextDecoration.Underline
                ),
            ) { append(url) }
        },
        overflow = TextOverflow.Ellipsis,
        maxLines = 3,
    ) {
        localUriHandler.openUri(url)
    }
}
