package com.sample.features.favorite.domain.model

data class FavoriteMovieModel(
    val imgUrl: String,
    val id:Int,
    val adult: Boolean,
    val title: String,
    val overview: String,
    val popularity: Double,
    val voteCount: Int
)
