package com.cristian.dragonballcristian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cristian.dragonballcristian.ui.Screens.AppContent
import com.cristian.dragonballcristian.ui.Screens.showCharacter
import com.cristian.dragonballcristian.ui.Screens.showCharacterList
import com.cristian.dragonballcristian.ui.theme.DragonBallCristianTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DragonBallCristianTheme {
                AppContent {padding ->
                    var selectedCharacter by rememberSaveable {
                        mutableStateOf(0)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        showCharacterList() {selectedId ->
                            selectedCharacter = selectedId
                        }
                        showCharacter(characterId = selectedCharacter)
                    }
                }
            }
        }
    }
}

