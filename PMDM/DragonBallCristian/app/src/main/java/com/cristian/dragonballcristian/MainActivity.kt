package com.cristian.dragonballcristian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cristian.dragonballcristian.ui.Screens.AppContent
import com.cristian.dragonballcristian.ui.theme.DragonBallCristianTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragonBallCristianTheme {
                AppContent()
            }
        }
    }
}

