package com.retrofetch.data.mapper

import com.retrofetch.data.remote.model.UserDto
import com.retrofetch.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        name = login,
        avatar = avatar_url
    )
}