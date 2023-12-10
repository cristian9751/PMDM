package com.cristian.dragonballcristian.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.cristian.dragonballcristian.Characters.Character
import com.cristian.dragonballcristian.R


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun showCharacterList(modifier : Modifier, selectedCharacter : Int, select : (Int) -> Unit) {
    val charactersGroupedByName: Map<Char, List<Character>> =
        Character.getCharacters().groupBy { character ->
            character.spanishName[0]
        }
    LazyColumn(
        modifier = modifier,
    ) {

        items(charactersGroupedByName.entries.toList()) { (letter, characterList) ->
            LazyRow(
                userScrollEnabled = false
            ) {
                stickyHeader {
                    Text(
                        text = letter.toString(),
                        fontSize = 30.sp,
                        color = colorResource(id = R.color.dark_orange)
                    )
                }

                item {
                    Column(
                    ) {
                        characterList.forEach { character ->
                            var isSelected = character.id == selectedCharacter
                            Button(
                                onClick = {
                                select(character.id)
                            }) {
                                if(isSelected) {
                                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                                }
                                Text(
                                    text = character.spanishName
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}




