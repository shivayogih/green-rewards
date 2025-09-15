
package com.greenrewards.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
fun ProfileSetupScreen(
    onProfileSetupComplete: (Int, String, Float, String, List<String>) -> Unit
) {
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    val ecoGoals = remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") }
        )
        TextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender") }
        )
        TextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") }
        )
        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") }
        )

        Text(text = "Eco-goals")
        val walking = remember { mutableStateOf(false) }
        val cycling = remember { mutableStateOf(false) }
        val reducingPlastic = remember { mutableStateOf(false) }
        val recycling = remember { mutableStateOf(false) }
        val publicTransport = remember { mutableStateOf(false) }

        Row {
            Checkbox(checked = walking.value, onCheckedChange = { walking.value = it })
            Text("Walking")
        }
        Row {
            Checkbox(checked = cycling.value, onCheckedChange = { cycling.value = it })
            Text("Cycling")
        }
        Row {
            Checkbox(checked = reducingPlastic.value, onCheckedChange = { reducingPlastic.value = it })
            Text("Reducing plastic")
        }
        Row {
            Checkbox(checked = recycling.value, onCheckedChange = { recycling.value = it })
            Text("Recycling")
        }
        Row {
            Checkbox(checked = publicTransport.value, onCheckedChange = { publicTransport.value = it })
            Text("Using public transport")
        }

        Button(onClick = {
            val selectedGoals = mutableListOf<String>()
            if (walking.value) selectedGoals.add("Walking")
            if (cycling.value) selectedGoals.add("Cycling")
            if (reducingPlastic.value) selectedGoals.add("Reducing plastic")
            if (recycling.value) selectedGoals.add("Recycling")
            if (publicTransport.value) selectedGoals.add("Using public transport")
            ecoGoals.value = selectedGoals

            onProfileSetupComplete(
                age.toInt(),
                gender,
                weight.toFloat(),
                location,
                ecoGoals.value
            )
        }) {
            Text(text = "Complete Profile")
        }
    }
}
