package com.cristianpopica.singincristian.ui.Screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import java.util.logging.Filter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chipsActionMovies(chipOptions : List<String>) {
    var scrollState =  rememberScrollState(0)
    val selectedChips by rememberSaveable {
        mutableStateOf( mutableSetOf<String>())
    }
    var oneChipSelected by rememberSaveable {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        chipOptions.forEach{movieName ->
            var selected = selectedChips.contains(movieName)
            FilterChip(selected = selected ,
                onClick = {
                            selected = !selected;
                          if(selected)  {
                              selectedChips.remove(movieName)
                          } else {
                              selectedChips.add(movieName)
                          }
                    oneChipSelected = selected
                }
                , label = { Text(text = "$movieName") })
        }
    }
}