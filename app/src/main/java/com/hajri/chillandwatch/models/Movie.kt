package com.hajri.chillandwatch.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    var id: Int,

    @SerializedName("original_language")
    var originalLanguage: String,

    var overview: String,

    var title: String,

    var popularity: Double,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("vote_average")
    var voteAverage: Double,

    @SerializedName("vote_count")
    var voteCount: Int
) : Serializable
