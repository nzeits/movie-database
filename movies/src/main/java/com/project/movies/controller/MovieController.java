package com.project.movies.controller;

import com.project.movies.dao.MovieDao;
import com.project.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieDao movieDao;

    @Autowired
    public MovieController(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @GetMapping(path = "/{id}")
    public Movie getMovie(@PathVariable int id){
        return movieDao.getMovie(id);
    }

    @GetMapping
    public List<Movie> getAllMovies(@RequestParam(required = false, value = "rating", defaultValue = "0") double rating){
        if (rating != 0){
            return movieDao.getMoviesByRating(rating);
        }
        return movieDao.getAllMovies();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public boolean addMovie(@Valid @RequestBody Movie movie){
        return movieDao.addMovie(movie);
    }

    @PutMapping(path = "/{id}")
    public boolean updateMovie(@Valid @PathVariable int id, @RequestBody Movie movie){
        return movieDao.updateMovie(id, movie);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public boolean deleteMovie(@PathVariable int id){
        return movieDao.deleteMovie(id);
    }

}
