package com.hajri.chillandwatch.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.hajri.chillandwatch.ChillAndWatchConstant
import com.hajri.chillandwatch.R
import com.hajri.chillandwatch.databinding.FragmentMovieDetailsBinding
import com.hajri.chillandwatch.models.Movie

class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    private var movieArg: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieArg = arguments?.getSerializable(ChillAndWatchConstant.MOVIE_BUNDLE_KEY) as Movie?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        initView()
        return binding.root
    }

    /**
     * Initialize all view components
     */
    private fun initView() {
        binding.mainToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }

        binding.collapsingToolbar.title = movieArg?.title
        binding.tvDescription.text =
            movieArg?.overview ?: getString(R.string.unavailable_description)
        Glide
            .with(this)
            .load(ChillAndWatchConstant.API_POSTER.plus(movieArg?.posterPath))
            .into(binding.ivDetailMovie)
    }
}