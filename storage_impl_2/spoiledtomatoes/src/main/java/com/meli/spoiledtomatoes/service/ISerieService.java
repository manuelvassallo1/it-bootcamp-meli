package com.meli.spoiledtomatoes.service;

import com.meli.spoiledtomatoes.model.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> findAllBySeasonsCountGreaterThan(Integer seasonsCount);
}
