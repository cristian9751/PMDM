package com.cristianpopica.workoutcristian.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cristianpopica.workoutcristian.ViewModel.MainViewModel
import com.cristianpopica.workoutcristian.ViewModel.WorkoutViewModel
import com.cristianpopica.workoutcristian.ui.screens.mainScreen
import com.cristianpopica.workoutcristian.ui.screens.workoutScreen


@Composable
fun Navigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.MainScreen.route) {
        composable(route = Routes.MainScreen.route) {
            mainScreen(mainViewModel, navController)
        }

        composable(route = Routes.WorkoutScreen.route) {
            workoutScreen(mainViewModel, navController)
        }
    }

}