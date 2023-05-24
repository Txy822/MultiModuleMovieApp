package com.sample.features.favorite.data.mapper

import com.sample.features.favorite.data.local.FavoriteMovieEntity
import com.sample.features.favorite.domain.model.FavoriteMovieModel

fun FavoriteMovieEntity.toFavoriteMovieModel(): FavoriteMovieModel =
    FavoriteMovieModel(
        imgUrl = imgUrl,
        adult = adult,
        id = id,
        title = title,
        overview = overview,
        popularity = popularity,
        voteCount = voteCount
    )

fun FavoriteMovieModel.toFavoriteMovieEntity(): FavoriteMovieEntity = FavoriteMovieEntity(
    imgUrl = imgUrl,
    adult = adult,
    id = id,
    title = title,
    overview = overview,
    popularity = popularity,
    voteCount = voteCount
)
