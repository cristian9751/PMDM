package com.cristianpopica.singincristian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cristianpopica.singincristian.ui.Screens.appContent
import com.cristianpopica.singincristian.ui.Screens.profileInfo
import com.cristianpopica.singincristian.ui.theme.SinginCristianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SinginCristianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column(
                       modifier = Modifier.fillMaxSize()
                   ) {
                       profileInfo(profileName = "Cristian Popica", profilePictureDrawableId = R.drawable.profilepicture)
                       appContent()
                   }
                }
            }
        }
    }
}

