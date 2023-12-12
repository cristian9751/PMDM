package com.cristianpopica.workoutcristian.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.cristianpopica.workoutcristian.ViewModel.MainViewModel
import com.cristianpopica.workoutcristian.ui.navigation.Routes

@Composable
fun mainScreen(mainViewModel: MainViewModel, navController : NavHostController) {
    val username by mainViewModel.username.observeAsState(initial = "")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Cada ejercicio es un paso más cerca de tu mejor versión. ¡Hazlo por ti, cada repetición cuenta!"
        )
        nameField(mainViewModel, username)
        repetitionButtons(mainViewModel)

        startWorkingOutButton(mainViewModel, navController, username)
    }
}


@Composable
fun nameField(mainViewModel: MainViewModel, username : String) {
    TextField(value = username, onValueChange = {username ->
        mainViewModel.setUserName(username)
    })

}


@Composable
fun repetitionButtons(mainViewModel: MainViewModel) {
    Row(
    ) {
        IconButton(onClick = {
            mainViewModel.substractRepetitions()
        }) {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Eliminar repeticion")
        }
        IconButton(onClick = {
            mainViewModel.addWorkoutRepetitions()
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir repeticion")
        }
    }


}
@Composable
fun startWorkingOutButton(mainViewModel: MainViewModel, navController : NavHostController, username : String) {
    val workoutRepetitions by mainViewModel.workoutRepetitions.observeAsState(0)
    val isValid : Boolean by remember(workoutRepetitions, username) {
        derivedStateOf{
            workoutRepetitions > 3 && isUserNameValid(username)
        }
    }
    Text(text = "Repeticiones:  $workoutRepetitions")
    Button(
        enabled = isValid,
        onClick = { navController.navigate(Routes.WorkoutScreen.route) },
    ) {
        Text(text = "Comenzar")
    }
}

fun isUserNameValid(username : String) : Boolean {
   return username.isNotEmpty()
}



