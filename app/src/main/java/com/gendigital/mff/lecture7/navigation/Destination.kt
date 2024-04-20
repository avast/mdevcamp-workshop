package com.gendigital.mff.lecture7.navigation

import android.os.Bundle

/**
 * Destinations for navigator.
 */
sealed class Destination(val route: String) {
    data object Search : Destination("search")
    data object UserDetail : Destination("user_detail/{$ARG_USER}") {
        fun createRoute(user: String) = "user_detail/$user"
        fun getUser(arguments: Bundle?): String? =
            arguments?.getString(ARG_USER)
    }

    companion object {
        /**
         * Argument for [UserDetail].
         */
        private const val ARG_USER = "user"
    }
}
