package com.cristian.dragonballcristian.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cristian.dragonballcristian.Characters.Character
import com.cristian.dragonballcristian.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun showCharacterList(select : (Int) -> Unit) {
    val charactersGroupedByName: Map<Char, List<Character>> =
        Character.getCharacters().groupBy { character ->
            character.spanishName[0]
        }
    LazyColumn{
        items(charactersGroupedByName.entries.toList()) {(letter, characterList) ->
            LazyRow {
                    stickyHeader{
                        Text(
                            text = letter.toString(),
                            fontSize = 30.sp,
                            color = colorResource(id = R.color.dark_orange)
                        )
                    }

                    item{
                        Column{
                            characterList.forEach{ character ->
                                TextButton(
                                    onClick = { select(character.id) },
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(start = 40.dp)
                                            .padding(vertical = 4.dp),
                                        text = character.spanishName,
                                        fontSize = 20.sp,
                                        color = colorResource(id = R.color.dark_red)
                                    )
                                }
                            }
                        }
                    }
            }    
        }
    }


}



