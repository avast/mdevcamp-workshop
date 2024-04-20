package com.gendigital.mff.lecture7.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gendigital.mff.lecture7.data.GithubRepository
import com.gendigital.mff.lecture7.data.User
import com.gendigital.mff.lecture7.viewmodels.UserData

@Composable
fun UserDetail(
    userData: UserData,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        UserCard(user = userData.user)

        Spacer(modifier = Modifier.height(24.dp))

        // Display list of repositories
        LazyColumn {
            items(userData.repositories) { repository ->
                RepositoryItem(repository)
                HorizontalDivider()
            }
        }
    }
}

@Composable
@Preview
private fun UserDetailPreview() {
    val user = User("preview-login", 0, "", "", "https://github.com/preview", "", "", "")

    UserDetail(
        UserData(
            user,
            listOf(
                GithubRepository(0, "preview1", "", user, false, "description 1"),
                GithubRepository(1, "preview2", "", user, false, "description 2")
            )
        )
    )
}
