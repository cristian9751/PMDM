package com.cristianpopica.workoutcristian.ui.screens

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.cristianpopica.workoutcristian.Model.Workout
import com.cristianpopica.workoutcristian.ViewModel.MainViewModel
import com.cristianpopica.workoutcristian.ViewModel.WorkoutViewModel


@Composable
fun workoutScreen(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    ) {
    val workoutViewModel = remember {
        WorkoutViewModel(mainViewModel.workoutRepetitions.value ?: 0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        userNameLabel(mainViewModel = mainViewModel)
        textIsWorkingOut(workoutViewModel = workoutViewModel)
        repetitionsText(workoutViewModel = workoutViewModel)
        startWorkoutButton(workoutViewModel = workoutViewModel)
        workoutGif(workoutViewModel = workoutViewModel, mainViewModel = mainViewModel)
        goBackButton(navController = navController)
    }
}


@Composable
fun userNameLabel(mainViewModel: MainViewModel) {
    val username by mainViewModel.username.observeAsState(initial = "")
    Text(text = " $username")
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
fun repetitionsText(workoutViewModel: WorkoutViewModel) {
    val currentRepetitions by workoutViewModel._currentRepetitions.observeAsState(initial = 0)
    Text(text = "Repeticiones: $currentRepetitions")
}

@Composable
fun textIsWorkingOut(workoutViewModel: WorkoutViewModel) {
    val isDoingWorkout by workoutViewModel._isDoingWorkout.observeAsState(initial = false)
    if(isDoingWorkout) {
        Text(text = "Haciendo ejercicio")
    } else {
        Text(text = "Comenzando ejercicio")
    }
}

@Composable
fun startWorkoutButton(workoutViewModel: WorkoutViewModel) {
    Button(onClick = {
        workoutViewModel.startWorkout()
    }) {
        Text(text = "Comenzar")
    }
}

@Composable
fun workoutGif(workoutViewModel: WorkoutViewModel, mainViewModel: MainViewModel) {
    val currentWorkout by workoutViewModel.currentWorkout.observeAsState(initial = Workout(0))
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components{
            if(SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(context)
                        .data(data = currentWorkout.gifResourceId)
                        .build(),
                    imageLoader = imageLoader
                ),
                contentDescription = "Excercise",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
}
