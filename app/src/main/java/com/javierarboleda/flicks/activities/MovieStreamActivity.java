package com.javierarboleda.flicks.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javierarboleda.flicks.R;
import com.javierarboleda.flicks.adapters.MovieStreamAdapter;
import com.javierarboleda.flicks.models.MovieResult;
import com.javierarboleda.flicks.network.MovieDbNetworkHelper;
import com.javierarboleda.flicks.utils.MovieDbUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieStreamActivity extends AppCompatActivity {

    private static final String TAG = MovieStreamActivity.class.getName();

    private MovieResult mMovieResult;
    private MovieStreamAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_stream);
        initRecyclerView();
        populateMovieResult();
    }

    private void initRecyclerView() {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movie_stream_recycler_view);
        mAdapter = new MovieStreamAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void updateRecyclerView() {
        mAdapter.setMovies(mMovieResult.getResults());
        mAdapter.notifyDataSetChanged();
    }

    private void populateMovieResult() {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson GSON = gsonBuilder.create();





        MovieDbNetworkHelper.post(MovieDbUtil.getRecentMoviesUrlString(), "", new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    String responseStr = response.body().string();

                    mMovieResult = GSON.fromJson(responseStr, MovieResult.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateRecyclerView();
                        }
                    });



                } else {

                    // todo improve error reporting
                    Log.d(TAG, "Something went wrong");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {

                // todo improve error reporting
                Log.d(TAG, "Something went wrong");
            }

        });

    }
}
