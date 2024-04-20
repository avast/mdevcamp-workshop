package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gendigital.mff.lecture7.data.User

/**
 * Card containing basic information about user.
 */
@Composable
fun UserCard(user: User) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = user.login,
                    style = MaterialTheme.typography.headlineMedium,
                )

                StarsCount(number = user.publicGists)

                ClickableLink(user.htmlUrl)
            }

            UrlImageIcon(url = user.avatarUrl)
        }
    }
}
