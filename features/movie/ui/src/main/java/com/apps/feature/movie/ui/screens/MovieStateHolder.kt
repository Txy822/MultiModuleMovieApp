package com.apps.feature.movie.ui.screens

import com.apps.features.movie.domain.model.Movie

data class MovieStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
