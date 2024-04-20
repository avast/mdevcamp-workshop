package com.gendigital.mff.lecture7.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * Github repository details.
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class GithubRepository(
    val id: Int,
    val name: String,
    @JsonNames("full_name") val fullName: String,
    val owner: User,
    val private: Boolean,
    val description: String = "",
)