package com.apps.features.movie.data.repository

import com.apps.features.movie.data.mapper.toMovieModel
import com.apps.features.movie.domain.model.Movie
import com.apps.features.movie.domain.repository.MovieRepository
import com.core.network.remotedatasource.DataSource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : MovieRepository {
    override suspend fun getMovieList(apikey: String, q: String): List<Movie> {
        return dataSource.getMovieList(apikey, q).results.map { it.toMovieModel() }
    }
}