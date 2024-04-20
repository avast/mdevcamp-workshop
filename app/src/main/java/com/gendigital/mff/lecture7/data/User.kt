package com.gendigital.mff.lecture7.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * Github user details.
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class User (
    val login: String,
    val id: Int,
    @JsonNames("avatar_url") val avatarUrl: String,
    @JsonNames("gravatar_id")val gravatarId: String = "",
    val url: String,
    @JsonNames("html_url") val htmlUrl: String,
    @JsonNames("followers_url") val followersUrl: String,
    @JsonNames("following_url") val followingUrl: String,
    @JsonNames("public_repos") val publicRepos: Int = 0,
    @JsonNames("public_gists") val publicGists: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,
)