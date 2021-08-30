package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findAllBySerieGenreNameContainsIgnoreCase(String name);
}
