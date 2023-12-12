package com.cristianpopica.workoutcristian.ui.screens

import android.graphics.ImageDecoder
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.cristianpopica.workoutcristian.ui.Model.MainViewModel
import com.cristianpopica.workoutcristian.ui.Model.Workout
import com.cristianpopica.workoutcristian.ui.Model.WorkoutScreenViewModel
import com.cristianpopica.workoutcristian.ui.navigation.Routes


@Composable
fun WorkOutScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    val workOutScreenViewModel  = WorkoutScreenViewModel()
    val isDoingWorkout by workOutScreenViewModel.isDoingWorkout.observeAsState(initial = false)
    val workoutList by workOutScreenViewModel.workoutList.observeAsState(initial = emptyList())
    val repetitionNumber by  mainViewModel.repetitionsNumber.observeAsState(initial = 3)
    val randomWorkouts : Set<Workout> = workoutList.shuffled().toSet()
    randomWorkouts.forEach {workout ->
        workOutScreenViewModel.setCurrentWorkout(workout)
        workOutScreenViewModel.startWorkout()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        while(isDoingWorkout) {
            workoutGif(workOutScreenViewModel)
            Text(text = "$repetitionNumber")
        }

        
        Text(text = "Has terminado")
    }




}

@Composable
fun workoutGif(workoutScreenViewModel : WorkoutScreenViewModel) {
    val workout by workoutScreenViewModel.currentWorkout.observeAsState(initial = Workout(0))
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if(SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()

    Image(painter = , contentDescription = )
}

