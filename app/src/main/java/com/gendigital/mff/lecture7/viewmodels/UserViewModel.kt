package com.gendigital.mff.lecture7.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gendigital.mff.lecture7.data.GithubRepository
import com.gendigital.mff.lecture7.data.User
import com.gendigital.mff.lecture7.repository.Repository
import com.gendigital.mff.lecture7.repository.network.NetworkRepository
import com.gendigital.mff.lecture7.utils.ViewModelResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel: ViewModel() {

    private val dataRepository: Repository by lazy {
        NetworkRepository()
    }

    private val _userDetails: MutableStateFlow<ViewModelResponseState<UserData>> =
        MutableStateFlow(ViewModelResponseState.Idle)

    val userDetails: StateFlow<ViewModelResponseState<UserData>>
        get() = _userDetails

    fun loadUserDetails(username: String) {
        _userDetails.update { ViewModelResponseState.Loading }

        viewModelScope.launch(Dispatchers.IO) {
            val user = dataRepository.getUser(username)
            val repositories = if (user != null) dataRepository.getUserRepository(username) else null

            if (user != null && repositories != null) {
                withContext(Dispatchers.Main) {
                    _userDetails.update { ViewModelResponseState.Success(UserData(user, repositories)) }
                }
            } else {
                withContext(Dispatchers.Main) {
                    _userDetails.update { ViewModelResponseState.Error }
                }
            }
        }
    }
}

/**
 * Data class for user data.
 *
 * @property user User information.
 * @property repositories List of repositories belonging to the user.
 */
data class UserData(
    val user: User,
    val repositories: List<GithubRepository>
)
