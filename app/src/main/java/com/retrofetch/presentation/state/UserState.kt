package com.retrofetch.presentation.state

import com.retrofetch.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)