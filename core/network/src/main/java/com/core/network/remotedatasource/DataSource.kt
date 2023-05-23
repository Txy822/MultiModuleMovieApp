package com.core.network.remotedatasource

import com.core.network.dto.MovieListResponse

interface DataSource {
    suspend fun getMovieList(apiKey:String,q:String):MovieListResponse
}