package com.javierarboleda.flicks.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.models.Movie;
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

        final String IMAGE_URL_BASE ="http://image.tmdb.org/t/p/w342";
        String imageUrl;
        int placeholderResourceId;

        if (mPortrait) {
            imageUrl = IMAGE_URL_BASE + movie.getPosterPath();
            placeholderResourceId = R.drawable.poster_placeholder_w342;
        } else {
            imageUrl = IMAGE_URL_BASE + movie.getBackdropPath();
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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView movieImageView;
        public TextView titleTextView;
        public TextView overviewTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImageView = (ImageView) itemView.findViewById(R.id.list_item_movie_image);
            titleTextView = (TextView) itemView.findViewById(R.id.list_item_title_text_view);
            overviewTextView = (TextView) itemView.findViewById(R.id.list_item_overview_text_view);
        }
    }
}
