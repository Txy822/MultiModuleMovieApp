package com.sample.features.favorite.domain.use_case

import com.core.common.Resource
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(
    private val favoriteMovieRepository: FavoriteMovieRepository
){
    suspend fun getFavoriteMovies(): Flow<Resource<List<FavoriteMovieModel>>> = favoriteMovieRepository.getFavoriteMovies()
    suspend fun insertMovie(movie: FavoriteMovieModel) =favoriteMovieRepository.insertMovie(movie)
    suspend fun deleteMovie(movie: FavoriteMovieModel) =favoriteMovieRepository.deleteMovie(movie)
}
