package com.project.movies.model;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Movie {
    private int movieId;
    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotNull(message = "The rating cannot be blank.")
    @Min(value = 1, message = "Rating must be between 1 and 5.")
    @Max(value = 5, message = "Rating must be between 1 and 5.")
    private double myRating;
    @NotNull(message = "The date added cannot be blank.")
    private LocalDate dateAdded;

    public Movie(int movieId, String title, double myRating, LocalDate dateAdded) {
        this.movieId = movieId;
        this.title = title;
        this.myRating = myRating;
        this.dateAdded = dateAdded;
    }

    public Movie(String title, double myRating, LocalDate dateAdded) {
        this.title = title;
        this.myRating = myRating;
        this.dateAdded = dateAdded;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMyRating() {
        return myRating;
    }

    public void setMyRating(double myRating) {
        this.myRating = myRating;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Movie \n" +
                "title: " + title +
                ", myRating: " + myRating +
                ", dateAdded: " + dateAdded;
    }
}
