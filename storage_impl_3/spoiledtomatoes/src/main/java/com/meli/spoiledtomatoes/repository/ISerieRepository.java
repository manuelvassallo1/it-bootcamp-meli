package com.meli.spoiledtomatoes.repository;

import com.meli.spoiledtomatoes.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s FROM Serie s WHERE SIZE(s.seasons) > :seasonsCount")
    List<Serie> findAllBySeasonsCountGreaterThan(Integer seasonsCount);
}
