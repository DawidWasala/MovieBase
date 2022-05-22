package com.wasala.moviebase.repositories;

import com.wasala.moviebase.models.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
  @Override
  List<Genre> findAllById(Iterable<Long> longs);
}
