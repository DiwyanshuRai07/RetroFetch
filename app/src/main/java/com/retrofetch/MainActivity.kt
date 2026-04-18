package com.retrofetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.retrofetch.data.remote.GitHubApi
import com.retrofetch.data.repository.UserRepositoryImpl
import com.retrofetch.di.AppModule
import com.retrofetch.domain.repository.UserRepository
import com.retrofetch.domain.usecase.GetUsersUseCase
import com.retrofetch.presentation.ui.UserScreen
import com.retrofetch.presentation.viewmodel.UserViewModel
import com.retrofetch.ui.theme.RetroFetchTheme

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

