package com.retrofetch.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retrofetch.domain.usecase.GetUsersUseCase
import com.retrofetch.presentation.state.UserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    fun loadUsers() {
        viewModelScope.launch {
            _state.value = UserState(isLoading = true)

            try {
                val users = getUsersUseCase()
                _state.value = UserState(users = users)
            } catch (e: Exception) {
                _state.value = UserState(error = e.message ?: "Error")
            }
        }
    }
}