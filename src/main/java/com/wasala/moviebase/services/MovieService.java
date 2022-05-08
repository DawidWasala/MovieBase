package com.wasala.moviebase.services;

import com.wasala.moviebase.exceptions.MovieNotFoundException;
import com.wasala.moviebase.models.Movie;
import com.wasala.moviebase.repositories.MovieRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> findAllMovies() {
    return movieRepository.findAll();
  }

  public Movie findMovieById(Long id) throws MovieNotFoundException {
    return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
  }

  public Movie createMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

  public Movie updateMovie(Movie movie) {
    return movieRepository.save(movie);
  }
}
