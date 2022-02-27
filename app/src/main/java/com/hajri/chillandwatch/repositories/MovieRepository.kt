package com.hajri.chillandwatch.repositories

import com.hajri.chillandwatch.dataSources.IMovieRemoteDataSource
import com.hajri.chillandwatch.models.Movie
import io.reactivex.rxjava3.core.Single

class MovieRepository(private val movieDataSource: IMovieRemoteDataSource) : IMovieRepository {
    override fun getLatestMovies(): Single<List<Movie>> {
        return movieDataSource.getLatestMovies()
    }
}