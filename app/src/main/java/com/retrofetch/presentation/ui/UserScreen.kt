package com.retrofetch.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.retrofetch.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(vm: UserViewModel = viewModel()) {

    val state = vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.loadUsers()
    }

    Scaffold(
        Modifier.background(color = Color(0xFFFFFFFF)),
    ) { padding ->
    if (state.value.isLoading) {
       Text("isLoading")
    }
    else {
        LazyColumn(
            modifier = Modifier
                .background(color = Color(0xFFFFFFFF))
                .padding(padding)
                .fillMaxSize()
        ) {
            items(state.value.users, key = { it.id }) { userName ->
                Card(
                    modifier = Modifier
                        .background(color = Color(0xFFFFFFFF))
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .background(color = Color(0xFFA19BE0))
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = userName.name)

                    }
                }

            }

        }
    }
        }

    state.value.users.forEach {
        println(it.name)
    }

    if (state.value.error.isNotEmpty()) {
        println("Error: ${state.value.error}")
    }
}