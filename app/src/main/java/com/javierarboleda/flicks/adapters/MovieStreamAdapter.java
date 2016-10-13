package com.javierarboleda.flicks.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.models.Movie;

/**
 * Created on 10/11/16.
 */
public class MovieStreamAdapter extends RecyclerView.Adapter<MovieStreamAdapter.ViewHolder> {

    private Movie[] mMovies;
    private Context mContext;

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

        public TextView titleTextView;
        public TextView overviewTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.list_item_title_text_view);
            overviewTextView = (TextView) itemView.findViewById(R.id.list_item_overview_text_view);
        }
    }
}
