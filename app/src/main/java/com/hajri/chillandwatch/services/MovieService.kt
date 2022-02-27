package com.hajri.chillandwatch.services

import com.hajri.chillandwatch.models.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    /**
     * Get a list of movies in theatres from API
     *
     * @return [Single] of [Response] of [MoviesResponse]
     */
    @GET("/3/movie/now_playing")
    fun fetchLatestMovies(): Single<Response<MoviesResponse>>
}