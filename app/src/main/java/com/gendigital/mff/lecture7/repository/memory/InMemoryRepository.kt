package com.gendigital.mff.lecture7.repository.memory

import com.gendigital.mff.lecture7.data.GithubRepository
import com.gendigital.mff.lecture7.data.User
import com.gendigital.mff.lecture7.repository.Repository
import kotlinx.coroutines.runBlocking

/**
 * Static mock implementation of github data.
 */
class InMemoryRepository: Repository {

    override suspend fun getUser(username: String): User? = runBlocking {
        when (username) {
            "avast" -> avast
            "inmite" -> inmite
            "square" -> square
            else -> null
        }
    }

    override suspend fun getUserRepository(username: String): List<GithubRepository>? = runBlocking {
        val user = getUser(username)
        return@runBlocking if (user != null) {
            when (username) {
                "avast" -> AvastRepositories
                "inmite" -> listOf(
                    GithubRepository(
                        id = 13663078,
                        name = "android-validation-komensky",
                        description = "A simple library for validating user input in forms using annotations.",
                        fullName = "inmite/android-validation-komensky",
                        owner = user,
                        private = false),
                    GithubRepository(id = 12222625,
                        name = "android-selector-chapek",
                        description = "Android Studio plugin which automatically generates drawable selectors from appropriately named resources.",
                        fullName = "inmite/android-selector-chapek",
                        owner = user,
                        private = false),
                    GithubRepository(id = 10281119,
                        name = "android-grid-wichterle",
                        description = "This app will show grid overlay over whole system which helps you to verify your excellent app design.",
                        fullName = "inmite/android-grid-wichterle",
                        owner = user,
                        private = false))

                "square" -> listOf(
                    GithubRepository(id = 5152285,
                        name = "okhttp",
                        description = "An HTTP+HTTP/2 client for Android and Java applications.",
                        fullName = "square/okhttp",
                        owner = user,
                        private = false),
                    GithubRepository(id = 892275,
                        name = "retrofit",
                        description = "Type-safe HTTP client for Android and Java by Square, Inc.",
                        fullName = "square/retrofit",
                        owner = user,
                        private = false)
                )
                else -> null
            }
        } else {
            null
        }
    }

    companion object {
        val avast = User(
            login = "avast",
            id = 3996079,
            avatarUrl = "https://avatars1.githubusercontent.com/u/3996079?v=4",
            url = "https://api.github.com/users/avast",
            htmlUrl = "https://github.com/avast",
            followersUrl = "https://api.github.com/users/avast/followers",
            followingUrl = "https://api.github.com/users/avast/following{/other_user}",
            followers = 0,
            following = 0,
            publicGists = 0,
            publicRepos = 98
        )

        val inmite = User(
            login = "inmite",
            id = 3819616,
            avatarUrl = "https://avatars1.githubusercontent.com/u/3819616?v=4",
            url = "https://api.github.com/users/inmite",
            htmlUrl = "https://github.com/inmite",
            followersUrl = "https://api.github.com/users/inmite/followers",
            followingUrl = "https://api.github.com/users/inmite/following{/other_user}",
            followers = 0,
            following = 0,
            publicGists = 0,
            publicRepos = 10
        )

        val square = User(
            login = "square",
            id = 82592,
            avatarUrl = "https://avatars0.githubusercontent.com/u/82592?v=4",
            url = "https://api.github.com/users/square",
            htmlUrl = "https://github.com/square",
            followersUrl = "https://api.github.com/users/square/followers",
            followingUrl = "https://api.github.com/users/square/following{/other_user}",
            followers = 0,
            following = 0,
            publicGists = 5,
            publicRepos = 223
        )

        val AvastRepositories = listOf(
            GithubRepository(
                id = 15397085,
                name = "android-butterknife-zelezny",
                description = "Android Studio plug-in for generating ButterKnife injections from selected layout XML.",
                fullName = "avast/android-butterknife-zelezny",
                owner = avast,
                private = false),
            GithubRepository(id = 45212866,
                name = "android-lectures",
                description = "Class material for lectures about Android development",
                fullName = "avast/android-lectures",
                owner = avast,
                private = false),
            GithubRepository(id = 10281119,
                name = "android-styled-dialogs",
                description = "Class material for lectures about Android development",
                fullName = "avast/android-styled-dialogs",
                owner = avast,
                private = false))
    }
}
