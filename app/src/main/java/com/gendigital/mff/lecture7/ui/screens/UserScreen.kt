package com.gendigital.mff.lecture7.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gendigital.mff.lecture7.ui.components.CustomScaffold
import com.gendigital.mff.lecture7.ui.components.UserDetail
import com.gendigital.mff.lecture7.viewmodels.UserViewModel
import com.gendigital.mff.lecture7.utils.ViewModelResponseState
import com.gendigital.mff.lecture7.viewmodels.SearchViewModel

/**
 * Represents User detail with list of repositories.
 */
@ExperimentalMaterial3Api
@Composable
fun UserScreen(
    user: String?,
    viewModel: UserViewModel
) {
    val userDataResponse by viewModel.userDetails.collectAsState()

    CustomScaffold {
        when (userDataResponse) {
            is ViewModelResponseState.Idle -> {
                user?.let { viewModel.loadUserDetails(it) }
            }
            is ViewModelResponseState.Success -> {
                (userDataResponse as? ViewModelResponseState.Success)
                    ?.content
                    ?.let { UserDetail(userData = it) }
            }

            is ViewModelResponseState.Error -> Log.e(TAG, "Error has occurred")
            is ViewModelResponseState.Loading -> LoadingState()
        }
    }
}

@Composable
fun LoadingState() {
    CircularProgressIndicator(
        modifier = Modifier.width(48.dp)
    )
}

private const val TAG: String = "UserScreen"
