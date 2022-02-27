package com.hajri.chillandwatch.views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hajri.chillandwatch.ChillAndWatchConstant
import com.hajri.chillandwatch.R
import com.hajri.chillandwatch.databinding.MovieItemBinding
import com.hajri.chillandwatch.models.Movie

class MovieAdapter(
    private val listOfMovies: List<Movie>,
    private val context: Context,
    private val onMovieClicked: (movie: Movie) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieItem = listOfMovies[position]

        holder.binding.apply {
            tvMovieTitle.text = context.getString(R.string.movie_title).plus(movieItem.title)
            tvReleaseDate.text = context.getString(R.string.released_on).plus(movieItem.releaseDate)
            tvVoteCount.text =
                context.getString(R.string.total_voters).plus(movieItem.voteCount.toString())
            tvVoteAverage.text =
                context.getString(R.string.rating).plus(movieItem.voteAverage.toString())
            tvOriginalLanguage.text =
                context.getString(R.string.language).plus(movieItem.originalLanguage)

            Glide
                .with(context)
                .load(ChillAndWatchConstant.API_POSTER.plus(movieItem.posterPath))
                .into(ivMovie)
        }

        holder.itemView.setOnClickListener {
            onMovieClicked(movieItem)
        }
    }

    override fun getItemCount(): Int = listOfMovies.size

}
