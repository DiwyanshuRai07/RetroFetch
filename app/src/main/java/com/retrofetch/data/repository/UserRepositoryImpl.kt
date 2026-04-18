package com.retrofetch.data.repository

import com.retrofetch.data.remote.GitHubApi
import com.retrofetch.data.remote.model.toDomain
import com.retrofetch.domain.model.User
import com.retrofetch.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: GitHubApi
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }
}