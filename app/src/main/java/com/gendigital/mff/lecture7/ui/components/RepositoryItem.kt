package com.gendigital.mff.lecture7.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gendigital.mff.lecture7.data.GithubRepository
import com.gendigital.mff.lecture7.data.User

/**
 * Represents repository item in list of repositories for given user.
 */
@Composable
fun RepositoryItem(repository: GithubRepository) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Toast.makeText(context, repository.full_name, Toast.LENGTH_SHORT).show()
            }
    ) {
        Text(
            text = repository.name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = repository.description,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
@Preview
fun RepositoryItemPreview() {
    RepositoryItem(
        GithubRepository(
            0,
            name = "Preview github repository",
            full_name = "",
            owner =  User("user", 0, "", "", "", "", "", ""),
            private = false,
            description = "Description of this repository goes here"
        )
    )
}
