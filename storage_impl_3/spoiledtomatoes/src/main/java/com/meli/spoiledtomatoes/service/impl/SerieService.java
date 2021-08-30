package com.meli.spoiledtomatoes.service.impl;

import com.meli.spoiledtomatoes.model.dto.SerieDto;
import com.meli.spoiledtomatoes.model.mapper.SerieMapper;
import com.meli.spoiledtomatoes.repository.ISerieRepository;
import com.meli.spoiledtomatoes.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService implements ISerieService {

    private final ISerieRepository repository;

    @Override
    public List<SerieDto> findAllBySeasonsCountGreaterThan(Integer seasonsCount) {
        return SerieMapper.toSeriesDto(repository.findAllBySeasonsCountGreaterThan(seasonsCount));
    }
}
