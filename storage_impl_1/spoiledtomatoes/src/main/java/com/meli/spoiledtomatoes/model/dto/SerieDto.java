package com.meli.spoiledtomatoes.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SerieDto {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private String genreName;
}
