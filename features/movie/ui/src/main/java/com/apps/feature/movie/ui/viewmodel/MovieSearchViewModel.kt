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
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieState = mutableStateOf(MovieStateHolder())
    val movieSate: State<MovieStateHolder> get() = _movieState

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query
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
    private fun getMovieList(apiKey: String, q: String ) = viewModelScope.launch {
        getMovieListUseCase(apiKey, q).onEach {
            when (it) {
                is Resource.Loading -> {
                    _movieState.value = MovieStateHolder(isLoading = true)
                }
                is Resource.Error -> {
                    _movieState.value = MovieStateHolder(error = it.message.toString())
                }
                is Resource.Success -> {
                    _movieState.value = MovieStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}
