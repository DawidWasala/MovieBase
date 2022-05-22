package com.wasala.moviebase.services;

import com.wasala.moviebase.exceptions.GenreNotFoundException;
import com.wasala.moviebase.models.Genre;
import com.wasala.moviebase.payloads.requests.CreateGenreRequest;
import com.wasala.moviebase.repositories.GenreRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

  public Set<Genre> findAllGenresByIds(Iterable<Long> ids) {
    return new HashSet<>(genreRepository.findAllById(ids));
  }

  public Genre findGenreById(Long id) throws GenreNotFoundException {
    return genreRepository.findById(id).orElseThrow(GenreNotFoundException::new);
  }

  public Genre createGenre(CreateGenreRequest createGenreRequest) {
    Genre genre = new Genre();
    genre.setName(createGenreRequest.getName());
    return genreRepository.save(genre);
  }

  public void deleteGenre(Long id) {
    genreRepository.deleteById(id);
  }

  public Genre updateGenre(Long genreId, CreateGenreRequest createGenreRequest)
      throws GenreNotFoundException {
    Genre genreToUpdate = genreRepository.findById(genreId).orElseThrow(GenreNotFoundException::new);
    genreToUpdate.setName(createGenreRequest.getName());
    return genreRepository.save(genreToUpdate);
  }
}
