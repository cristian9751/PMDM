package com.cristianpopica.workoutcristian.ui.navigation

sealed class Routes(val route : String) {
    object MainScreen : Routes("main")
    object  WorkoutScreen : Routes("workout")
}