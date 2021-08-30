package com.meli.spoiledtomatoes.model.mapper;

import com.meli.spoiledtomatoes.model.dto.SerieDto;
import com.meli.spoiledtomatoes.model.entity.Serie;

import java.util.List;
import java.util.stream.Collectors;

public class SerieMapper {
    public static SerieDto toSerieDto(Serie serie) {
        return SerieDto.builder()
                .id(serie.getId())
                .title(serie.getTitle())
                .releaseDate(serie.getReleaseDate())
                .genreName(serie.getGenre().getName())
                .endDate(serie.getEndDate())
                .build();
    }

    public static List<SerieDto> toSeriesDto(List<Serie> series) {
        return series.stream()
                .map(SerieMapper::toSerieDto)
                .collect(Collectors.toList());
    }
}
