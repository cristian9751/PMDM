package com.cristian.dragonballcristian.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.cristian.dragonballcristian.Characters.Character

@Composable
fun showCharacter(characterId : Int) {
    if(characterId == 0) {
        Text(text = "Debes de seleccionar un personaje")
        return
    }
    val character = Character.getCharacterById(characterId)
    Column {
        Row {
            Text(text = """
                    Nombre español : ${character.spanishName}
                    Nombre japones : ${character.japaneseName}
                    Otro nombre :  ${character.otherName}
                """.trimIndent())
        }
    }
}