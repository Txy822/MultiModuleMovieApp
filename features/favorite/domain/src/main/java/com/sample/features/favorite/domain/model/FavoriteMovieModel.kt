package com.sample.features.favorite.domain.model

import android.os.Parcelable
import com.apps.features.movie.domain.model.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteMovieModel(
    val imgUrl: String,
    val id:Int,
    val adult: Boolean,
    val title: String,
    val overview: String,
    val popularity: Double,
    val voteCount: Int
) : Parcelable

fun Movie.toFavoriteMovieModel(): FavoriteMovieModel = FavoriteMovieModel(
    imgUrl = imgUrl,
    adult = adult,
    id = id,
    title = title,
    overview = overview,
    popularity = popularity,
    voteCount = voteCount
)