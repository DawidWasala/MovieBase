package com.wasala.moviebase.services;

import com.wasala.moviebase.exceptions.MovieNotFoundException;
import com.wasala.moviebase.models.Genre;
import com.wasala.moviebase.models.Movie;
import com.wasala.moviebase.payloads.requests.CreateMovieRequest;
import com.wasala.moviebase.repositories.MovieRepository;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;
  private final GenreService genreService;

  public MovieService(MovieRepository movieRepository, GenreService genreService) {
    this.movieRepository = movieRepository;
    this.genreService = genreService;
  }

  public List<Movie> findAllMovies() {
    return movieRepository.findAll();
  }

  public Movie findMovieById(Long id) throws MovieNotFoundException {
    return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
  }

  public Movie createMovie(CreateMovieRequest createMovieRequest) {
    Set<Genre> genres = genreService.findAllGenresByIds(createMovieRequest.getGenres());
    Movie movie = Movie.builder()
        .name(createMovieRequest.getName())
        .genres(genres)
        .build();
    return movieRepository.save(movie);
  }

  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

  public Movie updateMovie(Long movieId, CreateMovieRequest createMovieRequest)
      throws MovieNotFoundException {
    Set<Genre> genres = genreService.findAllGenresByIds(createMovieRequest.getGenres());
    Movie movie = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
    movie.setName(createMovieRequest.getName());
    movie.setGenres(genres);
    return movieRepository.save(movie);
  }
}
