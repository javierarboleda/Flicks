package com.javierarboleda.flicks.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.activities.MovieDetailsActivity;
import com.javierarboleda.flicks.models.Movie;
import com.javierarboleda.flicks.utils.AppConstants;
import com.javierarboleda.flicks.utils.MovieDbUtil;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created on 10/11/16.
 */
public class MovieStreamAdapter extends RecyclerView.Adapter<MovieStreamAdapter.ViewHolder> {

    private Movie[] mMovies;
    private Context mContext;
    private boolean mPortrait;

    public MovieStreamAdapter(Context context) {
        mMovies = new Movie[0];
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    public void setMovies(Movie[] movies) {
        mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mPortrait = mContext.getResources().getConfiguration().orientation
                        == Configuration.ORIENTATION_PORTRAIT;

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View movieListView = inflater.inflate(R.layout.list_item_movie, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(movieListView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovies[position];

        String imageUrl;
        int placeholderResourceId;

        if (mPortrait) {
            imageUrl = MovieDbUtil.IMAGE_URL_BASE + MovieDbUtil.IMAGE_SIZE_W342
                    + movie.getPosterPath();
            placeholderResourceId = R.drawable.poster_placeholder_w342;
        } else {
            imageUrl = MovieDbUtil.IMAGE_URL_BASE + MovieDbUtil.IMAGE_SIZE_W342
                    + movie.getBackdropPath();
            placeholderResourceId = R.drawable.backdrop_placeholder_w780;
        }

        ImageView movieImageView = holder.movieImageView;

        Picasso.with(getContext())
                .load(imageUrl)
                .fit()
                .centerCrop()
                .placeholder(placeholderResourceId)
                .transform(new RoundedCornersTransformation(10, 10))
                .into(movieImageView);

        TextView titleTextView = holder.titleTextView;
        titleTextView.setText(movie.getTitle());

        TextView overviewTextView = holder.overviewTextView;
        overviewTextView.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return mMovies.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView movieImageView;
        public TextView titleTextView;
        public TextView overviewTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImageView = (ImageView) itemView.findViewById(R.id.list_item_movie_image);
            titleTextView = (TextView) itemView.findViewById(R.id.list_item_title_text_view);
            overviewTextView = (TextView) itemView.findViewById(R.id.list_item_overview_text_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Movie movie = mMovies[getAdapterPosition()];

            Intent intent = new Intent(mContext, MovieDetailsActivity.class);
            intent.putExtra(AppConstants.BACKDROP_IMAGE_URL, MovieDbUtil.IMAGE_URL_BASE +
                    MovieDbUtil.IMAGE_SIZE_w780 + movie.getBackdropPath());
            intent.putExtra(AppConstants.MOVIE_TITLE, movie.getTitle());
            intent.putExtra(AppConstants.OVERVIEW, movie.getOverview());
            intent.putExtra(AppConstants.RELEASE_DATE,
                    MovieDbUtil.getHumanReadableReleaseDate(movie.getReleaseDate()));
            intent.putExtra(AppConstants.VOTE_AVERAGE, movie.getVoteAverage());
            intent.putExtra(AppConstants.POSTER_IMAGE_URL, MovieDbUtil.IMAGE_URL_BASE +
                    MovieDbUtil.IMAGE_SIZE_W342 + movie.getPosterPath());
            intent.putExtra(AppConstants.VOTE_COUNT, movie.getVoteCount());

            mContext.startActivity(intent);

        }
    }
}
