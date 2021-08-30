package com.meli.spoiledtomatoes.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EpisodeDto {
    private Long id;
    private String title;
    private Integer episodeNumber;
    private LocalDate releaseDate;
    private Double rating;
    private Integer seasonNumber;
    private String serieTitle;
}
