package com.meli.spoiledtomatoes.model.mapper;

import com.meli.spoiledtomatoes.model.dto.SeasonDto;
import com.meli.spoiledtomatoes.model.entity.Season;

import java.util.List;
import java.util.stream.Collectors;

public class SeasonMapper {
    public static SeasonDto toSeasonDto(Season season) {
        return SeasonDto.builder()
                .id(season.getId())
                .title(season.getTitle())
                .seasonNumber(season.getNumber())
                .releaseDate(season.getReleaseDate())
                .endDate(season.getEndDate())
                .serieTitle(season.getSerie().getTitle())
                .serieGenre(season.getSerie().getGenre().getName())
                .build();
    }

    public static List<SeasonDto> toSeasonsDto(List<Season> seasons) {
        return seasons.stream()
                .map(SeasonMapper::toSeasonDto)
                .collect(Collectors.toList());
    }
}
