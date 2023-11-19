package com.cristian.dragonballcristian.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cristian.dragonballcristian.Characters.Character
import com.cristian.dragonballcristian.R


@Composable
fun showCharacter(characterId: Int, modifier: Modifier) {
    if (characterId == 0) {
        Text(text = stringResource(id = R.string.no_char_selected))
        return
    }
    val character = Character.getCharacterById(characterId)

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                
            ) {
                Column(
                    modifier = Modifier.weight(7f)
                ) {
                    Text(
                        text = stringResource(id = R.string.info_subtitle),
                        fontSize = 30.sp,
                        color = colorResource(id = R.color.dark_red)
                    )
                    Divider()
                    Text(
                        fontSize = 20.sp, text = """
                                ${stringResource(id = R.string.spanish_name_label)} : ${character.spanishName}
                                ${stringResource(id = R.string.japanese_name_label)} : ${character.japaneseName}
                                ${stringResource(id = R.string.other_name_label)} : ${if(character.otherName == "") stringResource(
                            id = R.string.unspecified
                        ) else character.otherName}
                                """.trimIndent()
                    )
                    Divider()
                    
                    showInfo(
                        data = if(character.birthdayYear == 0) stringResource(id = R.string.unspecified) else character.birthdayYear, 
                        label = stringResource(id = R.string.birthday_year_label) 
                    )
                    showInfo(
                        data = character.gender,
                        label = stringResource(id = R.string.gender_label) 
                    )
                    
                    showInfo(
                        data = character.species,
                        label = stringResource(id = R.string.species_label)
                    )
                    
                    showInfo(
                        data = character.information,
                        label = stringResource(id = R.string.information_label)
                    )
                    
                    
                }
                AsyncImage(
                    modifier = Modifier.weight(3f),
                    model = character.photo,
                    contentScale = ContentScale.Inside,
                    contentDescription = null

                )
            }
        }
    }
}


@Composable
fun showInfo(data : Any, label : String) {
    Text(
        fontSize = 20.sp,
        text = "$label:",
        fontWeight = FontWeight.Black
    )
    Text(text = "$data")
}