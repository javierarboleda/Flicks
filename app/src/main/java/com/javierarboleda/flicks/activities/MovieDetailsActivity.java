package com.javierarboleda.flicks.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.utils.AppConstants;
import com.squareup.picasso.Picasso;

/**
 * Created on 10/16/16.
 */
public class MovieDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        TextView titleTextView = (TextView) findViewById(R.id.movie_details_title_text_view);
        TextView overviewTextView = (TextView) findViewById(R.id.movie_details_overview_text_view);
        TextView releaseDateTextView =
                (TextView) findViewById(R.id.movie_details_release_date_text_view);
        TextView voteCountTextView =
                (TextView) findViewById(R.id.movie_details_vote_count_text_view);
        ImageView backdropImageView =
                (ImageView) findViewById(R.id.movie_details_backdrop_image_view);
        ImageView posterImageView = (ImageView) findViewById(R.id.movie_details_poster_image_view);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);


        Picasso.with(this)
                .load(getIntent().getStringExtra(AppConstants.BACKDROP_IMAGE_URL))
                .fit()
                .placeholder(R.drawable.backdrop_placeholder_w780)
                .into(backdropImageView);

        Picasso.with(this)
                .load(getIntent().getStringExtra(AppConstants.POSTER_IMAGE_URL))
                .fit()
                .placeholder(R.drawable.poster_placeholder_w342)
                .into(posterImageView);

        titleTextView.setText(getIntent().getStringExtra(AppConstants.MOVIE_TITLE));
        overviewTextView.setText(getIntent().getStringExtra(AppConstants.OVERVIEW));
        releaseDateTextView.setText(getIntent().getStringExtra(AppConstants.RELEASE_DATE));
        voteCountTextView.setText(getIntent().getFloatExtra(AppConstants.VOTE_AVERAGE, 0f) +
                "/10 from " + getIntent().getIntExtra(AppConstants.VOTE_COUNT, 0) + " users");

        ratingBar
                .setRating(getIntent().getFloatExtra(AppConstants.VOTE_AVERAGE, 0f));

        Drawable drawable = ratingBar.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#FFFDEC00"), PorterDuff.Mode.SRC_ATOP);
    }
}
