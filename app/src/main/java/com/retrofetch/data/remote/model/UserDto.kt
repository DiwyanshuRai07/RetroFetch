package com.retrofetch.data.remote.model

import com.retrofetch.domain.model.User


data class UserDto(
    val id: Int,
    val login: String,
    val avatar_url: String
)

fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = login,
        avatar = avatar_url
    )
}
