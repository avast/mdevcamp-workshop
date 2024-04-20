package com.gendigital.mff.lecture7

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gendigital.mff.lecture7.navigation.Destination
import com.gendigital.mff.lecture7.ui.screens.SearchScreen
import com.gendigital.mff.lecture7.ui.screens.UserScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Search.route) {
        composable(Destination.Search.route) {
            SearchScreen(
                onSubmitClick = {
                    navController.navigate(Destination.UserDetail.createRoute(it))
                }
            )
        }
        composable(Destination.UserDetail.route) { backStackEntry ->
            val user = Destination.UserDetail.getUser(backStackEntry.arguments)
            UserScreen(user)
        }
    }
}
