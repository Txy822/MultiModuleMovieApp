package com.core.network.remotedatasource

import com.core.network.ApiService
import com.core.network.dto.MovieListResponse
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val apiService: ApiService
):DataSource{
    override suspend fun getMovieList(apiKey: String, q: String): MovieListResponse {
        return apiService.getMovieList(apiKey=apiKey, q=q)
    }
}