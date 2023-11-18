package com.cristian.dragonballcristian.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.cristian.dragonballcristian.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(content : @Composable (PaddingValues) -> Unit) {
    Scaffold(
        floatingActionButton = { FloatingButtonProfile()},
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.akira_name),
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.dark_blue),
                    titleContentColor = colorResource(id = R.color.darker_yellow)
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.dragonball_logo),
                            contentDescription = null,
                            modifier = Modifier.background(colorResource(id = R.color.dark_blue))
                        )
                    }
                }
            )
        },

    ) { padding ->
        content(padding)
    }
}

@Composable
fun FloatingButtonProfile() {
    var profileSelected by rememberSaveable {
        mutableStateOf(false)
    }

    if(profileSelected) {
        infoToggleAlertDialog(
            profileName = "Cristian",
            profilePictureDrawableId = R.drawable.ic_launcher_foreground
        ) {
            profileSelected = false
        }
    } else {
        FloatingActionButton(
            containerColor = colorResource(id = R.color.dark_blue),
            onClick = {
                profileSelected = true
            }
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = colorResource(id = R.color.darker_yellow)
            )
        }
    }



}

