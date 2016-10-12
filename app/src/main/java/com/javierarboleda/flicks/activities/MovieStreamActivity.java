package com.javierarboleda.flicks.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.models.MovieResult;
import com.javierarboleda.flicks.network.MovieDbNetworkHelper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieStreamActivity extends AppCompatActivity {

    private static final String TAG = MovieStreamActivity.class.getName();

    private MovieResult mMovieResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_stream);

        populateMovieResult();
    }

    private void populateMovieResult() {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        MovieDbNetworkHelper.post("https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                // todo improve error reporting
                Log.d(TAG, "Something went wrong");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    String responseStr = response.body().string();

                    mMovieResult = gson.fromJson(responseStr, MovieResult.class);

                } else {

                    // todo improve error reporting
                    Log.d(TAG, "Something went wrong");
                }
            }
        });
    }
}
