package com.core.network

import com.core.network.dto.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://api.themoviedb.org/3/search/movie?api_key=api_key&query=harry
    @GET(END_POINT)
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") q: String
    ): MovieListResponse

    companion object {
        const val END_POINT = "3/search/movie?"
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}