package com.retrofetch.domain.usecase

import com.retrofetch.domain.model.User
import com.retrofetch.domain.repository.UserRepository

class GetUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}