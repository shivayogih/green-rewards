package com.greenrewards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.greenrewards.core.ui.theme.GreenRewardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenRewardsTheme {
                Navigation()
            }
        }
    }
}
