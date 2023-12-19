package com.example.workoutcristian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cristianpopica.workoutcristian.ViewModel.MainViewModel
import com.cristianpopica.workoutcristian.ViewModel.WorkoutViewModel
import com.cristianpopica.workoutcristian.ui.navigation.Navigation
import com.example.workoutcristian.ui.theme.WorkoutCristianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutCristianTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Navigation(MainViewModel())
                }
            }
        }
    }
}