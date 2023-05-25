package com.sample.features.favorite.ui.viewmodel

import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.Resource
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import com.sample.features.favorite.domain.use_case.GetFavoriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val favoriteMovieUseCase: GetFavoriteMovieUseCase
) : ViewModel() {
    private val _favoriteMovieStates = MutableStateFlow(FavoriteMovieSateHolder())
    val favoriteMovieStates: StateFlow<FavoriteMovieSateHolder> = _favoriteMovieStates

    init {
        getFavorites()
    }
    fun onEvent(event: FavoriteMovieEvent) {
        when (event) {
            is FavoriteMovieEvent.AddFavorite -> {
                addMovieToFavorites( movie = event.movie)
            }
            is FavoriteMovieEvent.DeleteFavorite -> {
                removeMovieFromFavorites(movie = event.movie)
            }
        }
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.getFavoriteMovies().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _favoriteMovieStates.update { it.copy(favorites =result.data) }
                    }
                    is Resource.Loading -> {
                        _favoriteMovieStates.update { it.copy(isLoading = true) }
                    }
                    is Resource.Error -> {
                        _favoriteMovieStates.update { it.copy(error ="Error") }
                    }
                }
            }
        }
    }


    private fun addMovieToFavorites(movie: FavoriteMovieModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.insertMovie(movie)
        }
    }

    private fun removeMovieFromFavorites(movie: FavoriteMovieModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.deleteMovie(movie)
        }
    }
}
