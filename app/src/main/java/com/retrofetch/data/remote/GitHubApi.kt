package com.retrofetch.data.remote

import com.retrofetch.data.remote.model.UserDto
import retrofit2.http.GET

interface GitHubApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}