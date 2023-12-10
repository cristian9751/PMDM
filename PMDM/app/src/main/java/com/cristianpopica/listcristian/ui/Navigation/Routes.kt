package com.cristianpopica.listcristian.ui.Navigation

sealed class Routes(val route : String) {
    object MainScreen : Routes("main_screen")
    object MovieInfo : Routes("movie_info_screen")
}
