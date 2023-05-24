package com.sample.features.favorite.data.repo

import com.sample.features.favorite.data.local.FavoriteMovieDao
import com.sample.features.favorite.data.local.FavoriteMovieEntity
import com.sample.features.favorite.data.mapper.toFavoriteMovieEntity
import com.sample.features.favorite.data.mapper.toFavoriteMovieModel
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class FavoriteMovieRepositoryImpl @Inject constructor(
    private val movieDao: FavoriteMovieDao
    ):FavoriteMovieRepository {
    override suspend fun getFavoriteMovies(): Flow<List<FavoriteMovieModel>>
    = flow {
        try {
            movieDao.getFavoriteMovies().map { it.toFavoriteMovieModel() }
        }
        catch (e: Exception){
            emit(emptyList())
        }
    }


    override suspend fun insertMovie(movie: FavoriteMovieModel) {
        movieDao.insertMovie(movie.toFavoriteMovieEntity())
    }

   override suspend fun deleteMovie(movie: FavoriteMovieModel) {
        movieDao.deleteMovie(movie.toFavoriteMovieEntity())
    }

}
