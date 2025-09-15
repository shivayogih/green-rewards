
package com.greenrewards.auth.ui

import androidx.compose.foundation.layout.* 
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.greenrewards.auth.AuthViewModel
import com.greenrewards.auth.AuthState
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(authViewModel: AuthViewModel = koinViewModel()) {
    val authState by authViewModel.authState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (authState) {
            is AuthState.Loading -> {
                CircularProgressIndicator()
            }
            is AuthState.Authenticated -> {
                val user = (authState as AuthState.Authenticated).user
                Text("Welcome, ${user.email}!")
            }
            is AuthState.Error -> {
                val error = (authState as AuthState.Error).message
                Text("Error: $error")
            }
            AuthState.Unauthenticated -> {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.padding(8.dp)
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.padding(8.dp)
                )
                Button(
                    onClick = { authViewModel.login(email, password) },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Login")
                }
            }
        }
    }
}

