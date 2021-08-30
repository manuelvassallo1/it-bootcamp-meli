package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findAllByFavoriteMovieIsNotNull();

    List<Actor> findAllByRatingGreaterThan(Double rating);

    List<Actor> findAllByActedMoviesTitleContainsIgnoreCase(String title);
}
