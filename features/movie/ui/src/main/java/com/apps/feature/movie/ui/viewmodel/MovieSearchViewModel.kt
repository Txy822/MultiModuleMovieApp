package com.apps.feature.movie.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.feature.movie.ui.BuildConfig
import com.apps.feature.movie.ui.screens.MovieStateHolder
import com.apps.features.movie.domain.use_case.GetMovieListUseCase
import com.core.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.FileInputStream
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = mutableStateOf(MovieStateHolder())
    val movieList: State<MovieStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query
    // two ways to store apis
    //first by build config inside the build.gradle of specified module
    private val apiKey = BuildConfig.API_KEY

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(apiKey, it.ifEmpty { "harry" })
            }
        }
    }

    fun setQuery(q:String){
        _query.value = q
    }
    fun getMovieList(apiKey: String, q: String ) = viewModelScope.launch {
        //        getMovieListUseCase.invoke(apiKey, q)
        getMovieListUseCase(apiKey, q).onEach {
//        getMovieListUseCase(apiKey, q).collect {
            when (it) {
                is Resource.Loading -> {
                    _movieList.value = MovieStateHolder(isLoading = true)
                }

                is Resource.Error -> {
                    _movieList.value = MovieStateHolder(error = it.message.toString())
                }

                is Resource.Success -> {
                    _movieList.value = MovieStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}
