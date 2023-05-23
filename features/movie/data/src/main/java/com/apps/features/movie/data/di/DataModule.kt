package com.apps.features.movie.data.di

import com.apps.features.movie.data.repository.MovieRepositoryImpl
import com.apps.features.movie.domain.repository.MovieRepository
import com.core.network.remotedatasource.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun providesMovieRepos(dataSource: DataSource): MovieRepository {
        return  MovieRepositoryImpl(dataSource)
    }
}