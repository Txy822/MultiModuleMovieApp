package com.sample.features.favorite.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class FavoriteMovieViewModel(private val repository: FavoriteMovieRepository) : ViewModel() {
    private val _favoriteMovies = MutableStateFlow<List<FavoriteMovieModel>>(emptyList())
    val favoriteMovies: StateFlow<List<FavoriteMovieModel>> = _favoriteMovies

    init {
        viewModelScope.launch {
            repository.favoriteMovies.collect {
                _favoriteMovies.value = it
            }
        }
    }

    fun addMovieToFavorites(movie: Movie) {
        viewModelScope.launch {
            repository.insertMovie(movie)
        }
    }

    fun removeMovieFromFavorites(movie: Movie) {
        viewModelScope.launch {
            repository.deleteMovie(movie)
        }
    }
}
