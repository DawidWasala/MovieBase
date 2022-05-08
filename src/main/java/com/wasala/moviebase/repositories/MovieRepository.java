package com.wasala.moviebase.repositories;

import com.wasala.moviebase.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
