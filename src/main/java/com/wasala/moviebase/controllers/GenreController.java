package com.wasala.moviebase.controllers;

import com.wasala.moviebase.exceptions.GenreNotFoundException;
import com.wasala.moviebase.models.Genre;
import com.wasala.moviebase.services.GenreService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController {

  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping
  public List<Genre> getGenres() {
    return genreService.findAllGenres();
  }

  @GetMapping(value = "/{genreId}")
  public Genre getGenreById(@PathVariable Long genreId) throws GenreNotFoundException {
    return genreService.findGenreById(genreId);
  }

  @PostMapping
  public Genre createGenre(@RequestBody Genre genre) {
    return genreService.createGenre(genre);
  }

  @DeleteMapping("/{genreId}")
  public void deleteGenre(@PathVariable Long genreId) {
    genreService.deleteGenre(genreId);
  }
}

