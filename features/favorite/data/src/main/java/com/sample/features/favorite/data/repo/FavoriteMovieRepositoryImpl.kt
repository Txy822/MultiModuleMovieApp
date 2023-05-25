package com.sample.features.favorite.data.repo

import com.core.common.Resource
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import com.sample.features.favorite.data.local.FavoriteMovieDao
import com.sample.features.favorite.data.local.FavoriteMovieEntity
import com.sample.features.favorite.data.mapper.toFavoriteMovieEntity
import com.sample.features.favorite.data.mapper.toFavoriteMovieModel
import com.sample.features.favorite.domain.model.FavoriteMovieModel
import com.sample.features.favorite.domain.repo.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class FavoriteMovieRepositoryImpl @Inject constructor(
    private val movieDao: FavoriteMovieDao
) : FavoriteMovieRepository {
    override suspend fun getFavoriteMovies(): Flow<Resource<List<FavoriteMovieModel>>> = flow {
        emit(Resource.Loading(true))
        try {
            val result = movieDao.getFavoriteMovies().map { it.toFavoriteMovieModel() }
            emit(Resource.Success(data = result))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            emit(Resource.Loading(false))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error("Couldn't load data"))
            emit(Resource.Loading(false))
        }
        emit(Resource.Loading(false))

    }


    override suspend fun insertMovie(movie: FavoriteMovieModel) {
        movieDao.insertMovie(movie.toFavoriteMovieEntity())
    }

    override suspend fun deleteMovie(movie: FavoriteMovieModel) {
        movieDao.deleteMovie(movie.toFavoriteMovieEntity())
    }

}
