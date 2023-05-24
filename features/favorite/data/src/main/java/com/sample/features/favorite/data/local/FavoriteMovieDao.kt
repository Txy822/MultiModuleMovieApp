package com.sample.features.favorite.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: FavoriteMovieEntity)

    @Delete
    suspend fun deleteMovie(movie: FavoriteMovieEntity)

    @Query("SELECT * FROM movies")
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>>
}
