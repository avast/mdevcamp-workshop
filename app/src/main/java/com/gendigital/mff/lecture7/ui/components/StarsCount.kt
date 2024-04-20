package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gendigital.mff.lecture7.R

/**
 * View containing icon of start and [number] of evaluation next to it.
 */
@Composable
fun StarsCount(number: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_star_outline),
            contentDescription = null,
        )

        Text(text = number.toString())
    }
}
