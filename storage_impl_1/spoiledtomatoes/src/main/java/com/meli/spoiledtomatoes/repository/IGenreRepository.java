package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
