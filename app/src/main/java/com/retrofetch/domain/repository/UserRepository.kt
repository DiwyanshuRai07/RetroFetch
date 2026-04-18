package com.retrofetch.domain.repository

import com.retrofetch.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}