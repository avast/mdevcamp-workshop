package com.gendigital.mff.lecture7.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gendigital.mff.lecture7.R
import com.gendigital.mff.lecture7.navigation.Destination
import com.gendigital.mff.lecture7.ui.components.CustomScaffold
import com.gendigital.mff.lecture7.viewmodels.SearchViewModel

/**
 * Represents screen for user search.
 */
@ExperimentalMaterial3Api
@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val lastUsername by viewModel.getLastUsername(context).collectAsState(initial = null)
    var searchText by rememberSaveable { mutableStateOf("") }

    CustomScaffold {
        Text(
            text = if (lastUsername.isNullOrBlank()) {
                stringResource(R.string.unknown)
            } else {
                stringResource(R.string.last_searched, lastUsername.toString())
            },
            modifier = Modifier.padding(bottom = 48.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(text = stringResource(R.string.txt_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                viewModel.saveLastUsername(context, searchText)
                navController.navigate(Destination.UserDetail.createRoute(searchText))
            }
        ) {
            Text(text = stringResource(R.string.btn_submit))
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(SearchViewModel(), NavController(LocalContext.current))
}
