package com.apps.features.movie.domain.di

import com.apps.features.movie.domain.repository.MovieRepository
import com.apps.features.movie.domain.use_case.GetMovieListUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesMovieListUseCase(movieRepository: MovieRepository): GetMovieListUseCase {
        return GetMovieListUseCase(movieRepository)
    }

}
