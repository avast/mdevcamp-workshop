package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gendigital.mff.lecture7.R

/**
 * View containing icon of start and [number] of evaluation next to it.
 */
@Composable
fun StarsCount(
    number: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_star_outline),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(text = number.toString())
    }
}
