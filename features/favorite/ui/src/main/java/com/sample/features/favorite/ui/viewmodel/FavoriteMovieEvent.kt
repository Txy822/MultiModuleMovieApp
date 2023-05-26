package com.sample.features.favorite.ui.viewmodel

import com.sample.features.favorite.domain.model.FavoriteMovieModel

sealed class FavoriteMovieEvent{
    data class DeleteFavorite(val movie: FavoriteMovieModel) : FavoriteMovieEvent()
    data class AddFavorite(val movie: FavoriteMovieModel) : FavoriteMovieEvent()
    object LoadFavorites: FavoriteMovieEvent()
}
