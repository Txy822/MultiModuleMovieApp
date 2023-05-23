package com.apps.features.movie.data.mapper

import com.apps.features.movie.domain.model.Movie
import com.core.network.dto.MovieDto
import com.core.network.dto.MovieListResponse

fun MovieListResponse.toDomainMovieList(): List<Movie>{
    return  this.results.map {
        Movie(it.posterPath)
    }
}

fun MovieDto.toMovieModel(): Movie = Movie(imgUrl = posterPath)