package com.project.movies.dao;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import com.project.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class MovieDaoJdbc implements MovieDao{

    JdbcTemplate jdbcTemplate;

    public MovieDaoJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

//    public MovieDaoJdbc(DataSource dataSource){
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public Movie getMovie(int movieId) {
        Movie movie = null;
        String sql = "SELECT movie_id, title, my_rating, date_watched " +
                "FROM movie WHERE movie_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, movieId);
        if (results.next()){
            movie = mapRowToMovie(results);
        }
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id, title, my_rating, date_watched FROM movie";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByRating(double rating) {
        List<Movie> movies = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT movie_id, title, my_rating, date_watched " +
                "FROM movie WHERE my_rating = ?;", rating);
        while (results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public boolean addMovie(Movie movie) {
        String sql = "INSERT INTO movie (title, my_rating, date_watched) " +
                "VALUES (?, ?, ?);";
        return jdbcTemplate.update(sql, movie.getTitle(), movie.getMyRating(), movie.getDateAdded()) == 1;
    }

    @Override
    public boolean updateMovie(int movieId, Movie movie) {
        String sql = "UPDATE movie SET title = ?, my_rating = ?, date_watched = ? WHERE movie_id = ?";
        return jdbcTemplate.update(sql, movie.getTitle(), movie.getMyRating(), movie.getDateAdded(), movieId) == 1;
    }

    @Override
    public boolean deleteMovie(int movieId) {
       return jdbcTemplate.update("DELETE FROM movie WHERE movie_id = ?", movieId) == 1;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet){
        Movie movie = new Movie();
        movie.setMovieId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setMyRating(rowSet.getDouble("my_rating"));
        movie.setDateAdded(rowSet.getDate("date_watched").toLocalDate());
        return movie;
    }

}
