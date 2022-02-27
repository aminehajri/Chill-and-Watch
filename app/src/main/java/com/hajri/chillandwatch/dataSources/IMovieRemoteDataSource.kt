package com.hajri.chillandwatch.dataSources

import com.hajri.chillandwatch.models.Movie
import io.reactivex.rxjava3.core.Single
import com.hajri.chillandwatch.services.MovieService

interface IMovieRemoteDataSource {

    /**
     * Gets a list of movies from [MovieService].
     *
     *  @return [Single]of [List] of[Movie]
     */
    fun getLatestMovies(): Single<List<Movie>>
}