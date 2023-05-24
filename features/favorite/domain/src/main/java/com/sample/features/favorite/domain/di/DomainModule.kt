package com.sample.features.favorite.domain.di

import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import com.sample.features.favorite.domain.use_case.GetFavoriteMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providesMovieListUseCase(movieRepository: FavoriteMovieRepository): GetFavoriteMovieUseCase {
        return GetFavoriteMovieUseCase(movieRepository)
    }
}