package com.cristianpopica.workoutcristian.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.cristianpopica.workoutcristian.ui.Model.MainViewModel
import com.cristianpopica.workoutcristian.ui.Model.Workout
import com.cristianpopica.workoutcristian.ui.Model.WorkoutScreenViewModel


@Composable
fun WorkOutScreen(navHostController: NavHostController, mainViewModel: MainViewModel) {
    val workOutScreenViewModel  = WorkoutScreenViewModel()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        workoutGif(workOutScreenViewModel)
        repetitionNumber(mainViewModel)
    }
}

@Composable
fun workoutGif(workoutScreenViewModel : WorkoutScreenViewModel) {
    val workout by workoutScreenViewModel.currentWorkout.observeAsState(initial = Workout(0))
    Icon(painter = painterResource(id = workout.gifDrawableId ), contentDescription = "Ejercicio gif")
}

@Composable
    fun repetitionNumber(mainViewModel: MainViewModel) {
    val repetitionNumber by  mainViewModel.repetitionsNumber.observeAsState()
    Text(text = "$repetitionNumber")
}