package com.apps.features.movie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val imgUrl: String,
    val id:Int,
    val adult: Boolean,
    val title: String,
    val overview: String,
    val popularity: Double,
    val voteCount: Int
) : Parcelable
