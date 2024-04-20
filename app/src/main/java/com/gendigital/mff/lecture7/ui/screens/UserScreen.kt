package com.gendigital.mff.lecture7.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gendigital.mff.lecture7.ui.components.CustomScaffold
import com.gendigital.mff.lecture7.ui.components.UserDetail
import com.gendigital.mff.lecture7.utils.ViewModelResponseState
import com.gendigital.mff.lecture7.viewmodels.UserViewModel

/**
 * Represents User detail with list of repositories.
 */
@Composable
fun UserScreen(
    user: String?,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel()
) {
    val userDataResponse = viewModel.userDetails.collectAsState()

    CustomScaffold(modifier) {
        when (val data = userDataResponse.value) {
            is ViewModelResponseState.Idle -> {
                user?.let { viewModel.loadUserDetails(it) }
            }

            is ViewModelResponseState.Success -> {
                UserDetail(userData = data.content)
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
