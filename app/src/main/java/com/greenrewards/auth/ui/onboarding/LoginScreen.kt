
package com.greenrewards.auth.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit,
    onLoginWithGoogle: () -> Unit,
    onLoginWithPhone: () -> Unit,
    onForgotPassword: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(onClick = { onLogin(email, password) }) {
            Text(text = "Login")
        }
        Button(onClick = onLoginWithGoogle) {
            Text(text = "Sign in with Google")
        }
        Button(onClick = onLoginWithPhone) {
            Text(text = "Sign in with Phone")
        }
        Button(onClick = onForgotPassword) {
            Text(text = "Forgot Password?")
        }
    }
}
