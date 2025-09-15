
package com.greenrewards.activity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
fun LogActivityScreen(
    onLogActivity: (String, Map<String, String>) -> Unit
) {
    var activity by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var distance by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var imageProof by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val activities = listOf("Walking", "Cycling", "Recycled item", "No plastic used")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { expanded = true }) {
            Text(text = if (activity.isEmpty()) "Select activity" else activity)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            activities.forEach {
                DropdownMenuItem(onClick = { 
                    activity = it
                    expanded = false
                }, text = { Text(it) })
            }
        }

        if (activity == "Walking" || activity == "Cycling") {
            TextField(
                value = duration,
                onValueChange = { duration = it },
                label = { Text("Duration (minutes)") }
            )
            TextField(
                value = distance,
                onValueChange = { distance = it },
                label = { Text("Distance (km)") }
            )
        } else if (activity == "Recycled item" || activity == "No plastic used") {
            TextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("Quantity") }
            )
        }

        TextField(
            value = imageProof,
            onValueChange = { imageProof = it },
            label = { Text("Image Proof (optional)") }
        )

        Button(onClick = {
            val details = mutableMapOf<String, String>()
            if (duration.isNotEmpty()) details["duration"] = duration
            if (distance.isNotEmpty()) details["distance"] = distance
            if (quantity.isNotEmpty()) details["quantity"] = quantity
            if (imageProof.isNotEmpty()) details["imageProof"] = imageProof
            onLogActivity(activity, details)
        }) {
            Text(text = "Submit")
        }
    }
}
