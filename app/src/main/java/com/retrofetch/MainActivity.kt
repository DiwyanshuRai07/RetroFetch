package com.retrofetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.retrofetch.data.repository.UserRepositoryImpl
import com.retrofetch.di.AppModule
import com.retrofetch.domain.usecase.GetUsersUseCase
import com.retrofetch.presentation.ui.UserScreen
import com.retrofetch.presentation.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val api = AppModule.provideApi() // or however you create it

        val repository = UserRepositoryImpl(api)

        val getUsersUseCase = GetUsersUseCase(repository)

        val viewModel = UserViewModel(getUsersUseCase = getUsersUseCase)
        setContent {
            UserScreen(viewModel)
        }
    }
}

