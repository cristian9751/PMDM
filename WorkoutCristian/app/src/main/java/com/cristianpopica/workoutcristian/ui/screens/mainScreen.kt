package com.cristianpopica.workoutcristian.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cristianpopica.workoutcristian.ui.Model.MainViewModel

@Composable
fun MainScreen(navController : NavHostController, mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Frase motivadora")
        nameField(mainViewModel)
        repeatButton(mainViewModel)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nameField(mainViewModel: MainViewModel) {
    val userName by mainViewModel.userName.observeAsState(initial = "")
    TextField(value = userName, onValueChange = {mainViewModel.setUserName(it)})
}

@Composable
fun repeatButton(mainViewModel: MainViewModel) {
    val repeatWorkout by mainViewModel.repetitionsNumber.observeAsState(initial = 0)
    Button(onClick = { mainViewModel.setRepetitionNumber(repeatWorkout + 1) }) {
        Text(text = "Añadir repeticiones")
    }
    Text(text = "$repeatWorkout")

}











