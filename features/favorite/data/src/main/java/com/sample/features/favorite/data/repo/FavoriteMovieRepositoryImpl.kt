package com.sample.features.favorite.data.repo

import com.sample.features.favorite.data.local.FavoriteMovieDao
import com.sample.features.favorite.data.local.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow


class FavoriteMovieRepositoryImpl(private val movieDao: FavoriteMovieDao) {
    suspend fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>> = movieDao.getFavoriteMovies()

    suspend fun insertMovie(movie: FavoriteMovieEntity) {
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: FavoriteMovieEntity) {
        movieDao.deleteMovie(movie)
    }

}
