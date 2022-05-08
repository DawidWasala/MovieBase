package com.wasala.moviebase.repositories;

import com.wasala.moviebase.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
