package com.core.network.di

import com.core.network.ApiService
import com.core.network.remotedatasource.DataSource
import com.core.network.remotedatasource.DataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    @Provides
    fun providesDataSource(apiService: ApiService): DataSource {
        return  DataSourceImpl(apiService)
    }
}