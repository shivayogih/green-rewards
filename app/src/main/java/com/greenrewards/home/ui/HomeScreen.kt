
package com.greenrewards.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onLogActivity: () -> Unit,
    onViewWallet: () -> Unit,
    onViewMarketplace: () -> Unit,
    onViewChallenges: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Eco-coins meter")
        Text(text = "Daily eco-score")
        Button(onClick = onLogActivity) {
            Text(text = "Log Activity")
        }
        Button(onClick = onViewWallet) {
            Text(text = "Wallet")
        }
        Button(onClick = onViewMarketplace) {
            Text(text = "Marketplace")
        }
        Button(onClick = onViewChallenges) {
            Text(text = "Challenges")
        }
    }
}
