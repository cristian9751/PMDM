package com.cristianpopica.listcristian.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristianpopica.listcristian.Model.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>> = _movies
    private val _selectedMovie = MutableLiveData<Movie>()
    val selectedMovie : LiveData<Movie> = _selectedMovie

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading
    init {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _movies.value = Movie.getData()
            _isLoading.value = false
        }
    }


    fun deleteMovie(movie : Movie) {
        _movies.value = movies.value?.filter{ it != movie}
    }

    fun onMovieClicked(movie : Movie) {
        _selectedMovie.value = movie;
    }



    fun toggleFavorite() {
        val auxMovie : Movie? = _selectedMovie.value?.copy()
        auxMovie?.favorite = !auxMovie?.favorite!!
        _selectedMovie.value = auxMovie

        val updatedList = mutableListOf<Movie>()
        _movies.value?.forEach {
            val movie = it.copy()
            if(movie.title == _selectedMovie.value?.title) {
                movie.favorite = auxMovie.favorite

            }
            updatedList.add(movie)
        }

        _movies.value = updatedList
    }





}