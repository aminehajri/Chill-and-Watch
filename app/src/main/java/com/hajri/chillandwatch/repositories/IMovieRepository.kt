package com.hajri.chillandwatch.repositories

import com.hajri.chillandwatch.models.Movie
import com.hajri.chillandwatch.dataSources.MovieRemoteDataSource
import io.reactivex.rxjava3.core.Single

interface IMovieRepository {

    /**
     * Gets a list of movies from [MovieRemoteDataSource].
     *
     *  @return [Single]of [List] of[Movie]
     */
    fun getLatestMovies(): Single<List<Movie>>
}