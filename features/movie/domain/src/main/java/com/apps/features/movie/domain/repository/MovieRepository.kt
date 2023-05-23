package com.apps.features.movie.domain.repository

import com.apps.features.movie.domain.model.Movie

interface MovieRepository {

    suspend fun getMovieList(apikey:String, q:String):List<Movie>
}