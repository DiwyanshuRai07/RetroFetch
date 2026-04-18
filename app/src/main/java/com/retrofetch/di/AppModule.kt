package com.retrofetch.di

import com.retrofetch.data.remote.GitHubApi
import com.retrofetch.data.repository.UserRepositoryImpl
import com.retrofetch.domain.repository.UserRepository
import com.retrofetch.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): GitHubApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: GitHubApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    fun provideUseCase(repo: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(repo)
    }
}