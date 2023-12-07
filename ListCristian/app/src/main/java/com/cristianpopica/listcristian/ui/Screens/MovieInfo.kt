package com.cristianpopica.listcristian.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cristianpopica.listcristian.Model.Movie
import com.cristianpopica.listcristian.ViewModel.MovieViewModel

@Composable
fun MovieInfo(
    navHostController: NavHostController,
    movieViewModel: MovieViewModel
) {
    val movie : Movie by movieViewModel.selectedMovie.observeAsState(Movie())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.clickable {
                navHostController.popBackStack()
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver"
            )
            Text(text = "Volver")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Pelicula"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = movie.title,
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        IconButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                movieViewModel.toggleFavorite()
            }
        ) {
            Text(
                text = if(movie.favorite) "Quitar favoritos" else "Añadir favoritos")
        }

        Text(
            text = movie.director,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(8.dp)
        ) {
            Text(
                text = movie.description,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}