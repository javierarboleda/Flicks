package com.javierarboleda.flicks.models;

/**
 * Created on 10/11/16.
 */
public class MovieResult {

    private int page;
    private Movie[] results;
    private MovieDates dates;
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }

    public MovieDates getDates() {
        return dates;
    }

    public void setDates(MovieDates dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
