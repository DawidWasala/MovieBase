package com.wasala.moviebase.services;

import com.wasala.moviebase.exceptions.GenreNotFoundException;
import com.wasala.moviebase.models.Genre;
import com.wasala.moviebase.repositories.GenreRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

  private final GenreRepository genreRepository;

  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  public List<Genre> findAllGenres() {
    return genreRepository.findAll();
  }

  public Genre findGenreById(Long id) throws GenreNotFoundException {
    return genreRepository.findById(id).orElseThrow(GenreNotFoundException::new);
  }

  public Genre createGenre(Genre genre) {
    return genreRepository.save(genre);
  }

  public void deleteGenre(Long id) {
    genreRepository.deleteById(id);
  }

  public Genre updateGenre(Genre genre) {
    return genreRepository.save(genre);
  }
}
