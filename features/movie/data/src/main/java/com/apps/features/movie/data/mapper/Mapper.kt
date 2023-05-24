package com.apps.features.movie.data.mapper

import com.apps.features.movie.domain.model.Movie
import com.core.network.dto.MovieDto
import com.core.network.dto.MovieListResponse

fun MovieDto.toMovieModel(): Movie =
    Movie(imgUrl = makeFullUrl(posterPath),
        adult = adult,
        id = id,
        title = title,
        overview = overview,
        popularity = popularity,
        voteCount = voteCount
    )

fun makeFullUrl(path: String) = "https://image.tmdb.org/t/p/w500/${path}"