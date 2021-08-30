package com.meli.spoiledtomatoes.service.impl;

import com.meli.spoiledtomatoes.model.dto.SeasonDto;
import com.meli.spoiledtomatoes.model.mapper.SeasonMapper;
import com.meli.spoiledtomatoes.repository.ISeasonRepository;
import com.meli.spoiledtomatoes.service.ISeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonService implements ISeasonService {

    private final ISeasonRepository repository;

    @Override
    public List<SeasonDto> findAllBySerieGenre(String genreName) {
        return SeasonMapper.toSeasonsDto(repository.findAllBySerieGenreNameContainsIgnoreCase(genreName));
    }
}
