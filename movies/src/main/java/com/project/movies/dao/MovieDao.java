package com.project.movies.dao;

import com.project.movies.model.Movie;

import java.util.List;

public interface MovieDao {

    Movie getMovie(int movieId);

    List<Movie> getAllMovies();

    List<Movie> getMoviesByRating(double rating);

    boolean addMovie(Movie movie);

    boolean updateMovie(int movieId, Movie movie);

    boolean deleteMovie(int movieId);

}
