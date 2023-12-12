package com.cristianpopica.workoutcristian.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.cristianpopica.workoutcristian.Model.Workout
import com.cristianpopica.workoutcristian.ViewModel.MainViewModel
import com.cristianpopica.workoutcristian.ViewModel.WorkoutViewModel


@Composable
fun workoutScreen(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    workoutViewModel: WorkoutViewModel
    ) {
    var randomWorkouts : Set<Workout> = emptySet()
    LaunchedEffect(false) {
        randomWorkouts = workoutViewModel.workoutList.value?.shuffled()?.toSet() ?: emptySet()
    }

    randomWorkouts.forEach {workout ->
        workoutViewModel.startWorkout(workout)
    }

    Column {
        userNameLabel(mainViewModel = mainViewModel)
        workoutGif(workoutViewModel = workoutViewModel)
        goBackButton(navController = navController)
    }
}


@Composable
fun userNameLabel(mainViewModel: MainViewModel) {
    val username by mainViewModel.username.observeAsState(initial = "")
    Text(text = "Buenas $username")
}
@Composable
fun goBackButton(navController : NavHostController) {
    Button(onClick = {
        navController.popBackStack()
    }) {
        Text(text = "Volver atras")
    }
}

@Composable
fun workoutGif(workoutViewModel: WorkoutViewModel) {
    val isDoingWorkout by workoutViewModel.isDoingWorkout.observeAsState(initial = false)
    val currentWorkout by workoutViewModel.currentWorkout.observeAsState(initial = Workout(0))
    while(isDoingWorkout) {
    }
}
