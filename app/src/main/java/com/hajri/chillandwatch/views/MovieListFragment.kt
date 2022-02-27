package com.hajri.chillandwatch.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hajri.chillandwatch.ChillAndWatchConstant.MOVIE_BUNDLE_KEY
import com.hajri.chillandwatch.R
import com.hajri.chillandwatch.databinding.FragmentMovieListBinding
import com.hajri.chillandwatch.models.Movie
import com.hajri.chillandwatch.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    private val movieViewModel: MovieViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.getMovieList()
        movieViewModel.listOfMovies.observe(viewLifecycleOwner) {
            movieAdapter = MovieAdapter(it, requireContext(), ::handleMovieClick)
            binding.recyclerViewOfMovies.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
            }
        }
    }

    /**
     * Handle adapter click
     * navigate to [MovieDetailsFragment] and send [Bundle] of [Movie]
     * @param movie selected from movie list
     */
    private fun handleMovieClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putSerializable(MOVIE_BUNDLE_KEY, movie)
        findNavController().navigate(R.id.action_movieListFragment_to_movieDetailsFragment, bundle)
    }
}