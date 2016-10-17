package com.javierarboleda.flicks.utils;

import android.net.Uri;

import com.javierarboleda.flicks.BuildConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created on 10/13/16.
 */
public class MovieDbUtil {

    public final static String MOVIE_DB_BASE_URL = "https://api.themoviedb.org/3/movie/now_playing";
    public final static String API_KEY_PARAM = "api_key";
    public final static String VOTE_COUNT_PARAM = "vote_count.gte";
    public final static String VOTE_COUNT_MIN = "300";
    public final static String SORT_BY_PARAM = "sort_by";
    public final static String SORT_ORDER_DESCENDING = "desc";
    public final static String IMAGE_URL_BASE ="http://image.tmdb.org/t/p";
    public final static String IMAGE_SIZE_W342 = "/w342";
    public final static String IMAGE_SIZE_w500 = "/w500";
    public final static String IMAGE_SIZE_w780 = "/w780";

    public static String getRecentMoviesUrlString() {

        Uri builtUri = Uri.parse(MOVIE_DB_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARAM, BuildConfig.MOVIE_DB_API_KEY)
                .appendQueryParameter(VOTE_COUNT_PARAM, VOTE_COUNT_MIN)
                .appendQueryParameter(SORT_BY_PARAM, SORT_ORDER_DESCENDING)
                .build();

        return builtUri.toString();
    }

    public static String getHumanReadableReleaseDate(String releaseDate) {

        if (releaseDate == null || releaseDate.trim().isEmpty() || releaseDate.equals("null")) {
            return "";
        }

        Calendar cal = Calendar.getInstance();
        String[] yearMonthDay = releaseDate.split("-");

        int year = Integer.parseInt(yearMonthDay[0]);
        int month = Integer.parseInt(yearMonthDay[1]) - 1;
        int day = Integer.parseInt(yearMonthDay[2]);

        cal.set(year, month, day);
        SimpleDateFormat monthDayYearFormat = new SimpleDateFormat("MMMM d, yyyy");

        return monthDayYearFormat.format(cal.getTime());
    }

}
