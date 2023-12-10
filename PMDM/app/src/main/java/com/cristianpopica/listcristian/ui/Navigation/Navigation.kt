package com.cristianpopica.listcristian.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cristianpopica.listcristian.ViewModel.MovieViewModel
import com.cristianpopica.listcristian.ui.Screens.MainScreen
import com.cristianpopica.listcristian.ui.Screens.MovieInfo

@Composable
fun Navigation(movieViewModel : MovieViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, movieViewModel)
        }

        composable(Routes.MovieInfo.route) {
            MovieInfo(navController, movieViewModel)
        }
    }
}

