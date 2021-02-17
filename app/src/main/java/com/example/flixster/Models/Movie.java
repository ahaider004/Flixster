package com.example.flixster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    int votes;
    double rating;

    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        votes = jsonObject.getInt("vote_average");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");


    }

    public static List<Movie> fromJasonArray(JSONArray movieJasonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<movieJasonArray.length();i++){
            movies.add(new Movie(movieJasonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }
    public int getVotes(){
        return votes;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}

