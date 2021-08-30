package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findAllByActorsFirstNameContainsIgnoreCaseAndActorsLastNameContainsIgnoreCase(String firstName,
                                                                                                String lastName);
}
