package com.cristianpopica.workoutcristian.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cristianpopica.workoutcristian.ui.Model.MainViewModel
import com.cristianpopica.workoutcristian.ui.screens.MainScreen
import com.cristianpopica.workoutcristian.ui.screens.WorkOutScreen

@Composable
fun Navigation(mainViewModel : MainViewModel)  {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, mainViewModel)
        }

        composable(Routes.WorkOutScreen.route) {
            WorkOutScreen(navController, mainViewModel)

        }
    }
}