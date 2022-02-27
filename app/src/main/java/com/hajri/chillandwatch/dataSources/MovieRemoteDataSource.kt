package com.hajri.chillandwatch.dataSources

import com.hajri.chillandwatch.models.Movie
import com.hajri.chillandwatch.services.MovieService
import io.reactivex.rxjava3.core.Single
import retrofit2.HttpException

class MovieRemoteDataSource(private val movieService: MovieService) : IMovieRemoteDataSource {

    override fun getLatestMovies(): Single<List<Movie>> {
        return movieService.fetchLatestMovies().map { response ->
            if (response.isSuccessful) {
                response.body()!!.movies
            } else {
                throw HttpException(response)
            }
        }
    }
}
