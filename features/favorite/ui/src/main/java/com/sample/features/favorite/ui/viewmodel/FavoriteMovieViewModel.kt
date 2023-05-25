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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val favoriteMovieUseCase: GetFavoriteMovieUseCase
) : ViewModel() {
    private val _favoriteMovieStates = MutableStateFlow(FavoriteMovieSateHolder())
    val favoriteMovieStates: StateFlow<FavoriteMovieSateHolder> = _favoriteMovieStates.asStateFlow()

    init {
      // getFavorites()
    }
    fun onEvent(event: FavoriteMovieEvent) {
        when (event) {
            is FavoriteMovieEvent.AddFavorite -> {
               _favoriteMovieStates.update { it.copy( favoriteMovie = event.movie) }
                addMovieToFavorites()


            }
            is FavoriteMovieEvent.DeleteFavorite -> {
                _favoriteMovieStates.update { it.copy( favoriteMovie = event.movie) }
                    removeMovieFromFavorites()


            }
            is FavoriteMovieEvent.LoadFavorites->
                getFavorites()
        }
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.getFavoriteMovies().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _favoriteMovieStates.update { it.copy(favorites =result.data, isLoading = false) }
                    }
                    is Resource.Loading -> {
                        _favoriteMovieStates.update { it.copy(isLoading = true) }
                    }
                    is Resource.Error -> {
                        _favoriteMovieStates.update { it.copy(error ="Error", isLoading = false) }
                    }
                }
            }
        }
    }


    private fun addMovieToFavorites(movie: FavoriteMovieModel = _favoriteMovieStates.value.favoriteMovie!!) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.insertMovie(movie)
            getFavorites()
        }
    }

    private fun removeMovieFromFavorites(movie: FavoriteMovieModel = _favoriteMovieStates.value.favoriteMovie!!) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMovieUseCase.deleteMovie(movie)
            getFavorites()
        }
    }
}
