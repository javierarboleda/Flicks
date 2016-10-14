package com.javierarboleda.flicks.utils;

import android.net.Uri;

import com.javierarboleda.flicks.BuildConfig;

/**
 * Created on 10/13/16.
 */
public class MovieDbUtil {

    public final static String MOVIE_DB_BASE_URL = "https://api.themoviedb.org/3/movie/now_playing";
    public final static String API_KEY_PARAM = "api_key";
    public final static String VOTE_COUNT_PARAM = "vote_count.gte";
    public final static String VOTE_COUNT_MIN = "150";
    public final static String SORT_BY_PARAM = "sort_by";
    public final static String SORT_ORDER_DESCENDING = "desc";

    public static String getRecentMoviesUrlString() {

        Uri builtUri = Uri.parse(MOVIE_DB_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARAM, BuildConfig.MOVIE_DB_API_KEY)
                .appendQueryParameter(VOTE_COUNT_PARAM, VOTE_COUNT_MIN)
                .appendQueryParameter(SORT_BY_PARAM, SORT_ORDER_DESCENDING)
                .build();

        return builtUri.toString();
    }

}
