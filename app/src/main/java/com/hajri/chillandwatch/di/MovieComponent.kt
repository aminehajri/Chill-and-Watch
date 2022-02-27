package com.hajri.chillandwatch.di

import com.hajri.chillandwatch.dataSources.IMovieRemoteDataSource
import com.hajri.chillandwatch.dataSources.MovieRemoteDataSource
import com.hajri.chillandwatch.repositories.IMovieRepository
import com.hajri.chillandwatch.repositories.MovieRepository
import com.hajri.chillandwatch.services.MovieService
import com.hajri.chillandwatch.services.ServiceFactory
import com.hajri.chillandwatch.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MovieComponent = module {
    single { ServiceFactory.generate(MovieService::class.java) }
    single<IMovieRemoteDataSource> { MovieRemoteDataSource(get()) }
    single<IMovieRepository> { MovieRepository(get()) }
    viewModel { MovieViewModel(get()) }

}