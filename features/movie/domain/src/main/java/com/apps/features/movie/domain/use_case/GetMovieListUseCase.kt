package com.apps.features.movie.domain.use_case

import com.apps.features.movie.domain.model.Movie
import com.apps.features.movie.domain.repository.MovieRepository
import com.core.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(apiKey: String, q: String) = flow<Resource<List<Movie>>> {
        emit(Resource.Loading(true))
        emit(Resource.Success(movieRepository.getMovieList(apiKey,q)))
    }.catch {
        emit(Resource.Loading(false))
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}