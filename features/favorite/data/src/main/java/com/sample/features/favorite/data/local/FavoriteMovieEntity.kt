package com.sample.features.favorite.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class FavoriteMovieEntity(
    @PrimaryKey val id: Int,
    val imgUrl: String,
    val adult: Boolean,
    val title: String,
    val overview: String,
    val popularity: Double,
    val voteCount: Int
)
