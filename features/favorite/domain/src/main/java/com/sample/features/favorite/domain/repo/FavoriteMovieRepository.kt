package com.sample.features.favorite.domain.repo

import com.core.common.Resource
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import kotlinx.coroutines.flow.Flow

interface FavoriteMovieRepository {
    suspend fun getFavoriteMovies(): Flow<Resource<List<FavoriteMovieModel>>>

    suspend fun insertMovie(movie: FavoriteMovieModel)

    suspend fun deleteMovie(movie: FavoriteMovieModel)
}