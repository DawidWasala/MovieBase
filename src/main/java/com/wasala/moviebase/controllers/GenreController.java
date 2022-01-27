package com.wasala.moviebase.controllers;

import com.wasala.moviebase.exceptions.GenreNotFoundException;
import com.wasala.moviebase.models.Genre;
import com.wasala.moviebase.repositories.GenreRepository;
import com.wasala.moviebase.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Genre createGenre(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }

    @DeleteMapping("/{genreId}")
    public void deleteGenre(@PathVariable Long genreId){
        genreService.deleteGenre(genreId);
    }
}

