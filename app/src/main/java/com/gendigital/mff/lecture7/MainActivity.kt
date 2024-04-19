package com.gendigital.mff.lecture7

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gendigital.mff.lecture7.navigation.Destination
import com.gendigital.mff.lecture7.viewmodels.SearchViewModel
import com.gendigital.mff.lecture7.ui.screens.SearchScreen
import com.gendigital.mff.lecture7.ui.screens.UserScreen
import com.gendigital.mff.lecture7.viewmodels.UserViewModel

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Search.route) {
        composable(Destination.Search.route) {
            SearchScreen(viewModel<SearchViewModel>(), navController)
        }
        composable(Destination.UserDetail.route) { backStackEntry ->
            val user = backStackEntry.arguments?.getString(Destination.ARG_USER)
            UserScreen(user, viewModel<UserViewModel>())
        }
    }
}
