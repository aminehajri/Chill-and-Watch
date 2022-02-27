package com.hajri.chillandwatch.models

import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("results") var movies: List<Movie>
)