package com.sample.features.favorite.data.di

import android.app.Application
import androidx.room.Room
import com.sample.features.favorite.data.local.FavoriteMovieDao
import com.sample.features.favorite.data.local.FavoriteMovieDatabase
import com.sample.features.favorite.data.repo.FavoriteMovieRepositoryImpl
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMovieDatabase(application: Application): FavoriteMovieDatabase {
        return Room.databaseBuilder(
            application,
            FavoriteMovieDatabase::class.java,
            "movie_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: FavoriteMovieDatabase): FavoriteMovieDao {
        return movieDatabase.favoriteMovieDao()
    }
    @Provides
    @Singleton
    fun provideMovieRepository(movieDao: FavoriteMovieDao): FavoriteMovieRepository {
        return FavoriteMovieRepositoryImpl(movieDao)
    }
}