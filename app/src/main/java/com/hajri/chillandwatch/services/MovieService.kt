package com.hajri.chillandwatch.services

import com.hajri.chillandwatch.models.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    /**
     * Get a list of movies in theatres from API
     *
     * @return [Single] of [Response] of [MoviesResponse]
     */
    @GET("/3/movie/now_playing")
    fun fetchLatestMovies(): Single<Response<MoviesResponse>>


    /**
     * Get a list of movies with query from API
     * @param query to search with
     * @return [Single] of [Response] of [MoviesResponse]
     */
    @GET("/3/search/movie")
    fun fetchMovieByQuery(@Query("query") query: String): Single<Response<MoviesResponse>>
}