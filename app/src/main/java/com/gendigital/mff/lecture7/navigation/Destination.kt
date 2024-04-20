package com.gendigital.mff.lecture7.navigation

/**
 * Destinations for navigator.
 */
sealed class Destination(val route: String) {
    data object Search: Destination("search")
    data object UserDetail: Destination("user_detail/{$ARG_USER}") {
        fun createRoute(user: String) = "user_detail/$user"
    }

    companion object {
        /**
         * Argument for [UserDetail].
         */
        const val ARG_USER = "user"
    }
}
