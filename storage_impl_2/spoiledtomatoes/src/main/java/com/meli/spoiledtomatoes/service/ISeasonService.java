package com.meli.spoiledtomatoes.service;

import com.meli.spoiledtomatoes.model.dto.SeasonDto;

import java.util.List;

public interface ISeasonService {
    List<SeasonDto> findAllBySerieGenre(String genreName);
}
