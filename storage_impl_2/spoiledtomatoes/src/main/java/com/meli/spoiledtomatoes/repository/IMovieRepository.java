package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByActorsRatingGreaterThan(Double rating);

    List<Movie> findAllByGenreNameContainsIgnoreCase(String name);
}
