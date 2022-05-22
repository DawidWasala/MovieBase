package com.wasala.moviebase.controllers;

import com.wasala.moviebase.exceptions.MovieNotFoundException;
import com.wasala.moviebase.models.Movie;
import com.wasala.moviebase.payloads.requests.CreateMovieRequest;
import com.wasala.moviebase.services.MovieService;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public List<Movie> getMovies() {
    return movieService.findAllMovies();
  }

  @GetMapping(value = "/{movieId}")
  public Movie getMovieById(@PathVariable Long movieId) throws MovieNotFoundException {
    return movieService.findMovieById(movieId);
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public Movie createMovie(@RequestBody CreateMovieRequest createMovieRequest) {
    return movieService.createMovie(createMovieRequest);
  }

  @PutMapping(value = "{movieId}")
  @PreAuthorize("hasRole('ADMIN')")
  public Movie updateMovie(@PathVariable Long movieId, @RequestBody CreateMovieRequest movie)
      throws MovieNotFoundException{
    return movieService.updateMovie(movieId, movie);
  }

  @DeleteMapping("/{movieId}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteMovie(@PathVariable Long movieId) {
    movieService.deleteMovie(movieId);
  }
}
