package com.sample.features.favorite.ui.viewmodel

import com.sample.features.favorite.domain.model.FavoriteMovieModel

data class FavoriteMovieSateHolder(
    val isLoading:Boolean = false,
    val favorites: List<FavoriteMovieModel>? =null,
    val error :String = ""
)

