package com.cristianpopica.workoutcristian.ui.navigation

sealed class Routes(val route : String) {
    object MainScreen : Routes("main_screen")
    object WorkOutScreen : Routes("workout_screen")
}
