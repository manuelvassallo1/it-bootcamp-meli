package com.meli.spoiledtomatoes.model.mapper;

import com.meli.spoiledtomatoes.model.dto.EpisodeDto;
import com.meli.spoiledtomatoes.model.entity.Episode;

import java.util.List;
import java.util.stream.Collectors;

public class EpisodeMapper {
    public static EpisodeDto toEpisodeDto(Episode episode) {
        return EpisodeDto.builder()
                .id(episode.getId())
                .title(episode.getTitle())
                .episodeNumber(episode.getNumber())
                .releaseDate(episode.getReleaseDate())
                .rating(episode.getRating())
                .seasonNumber(episode.getSeason().getNumber())
                .serieTitle(episode.getSeason().getSerie().getTitle())
                .build();
    }

    public static List<EpisodeDto> toEpisodesDto(List<Episode> episodes) {
        return episodes.stream()
                .map(EpisodeMapper::toEpisodeDto)
                .collect(Collectors.toList());
    }
}
