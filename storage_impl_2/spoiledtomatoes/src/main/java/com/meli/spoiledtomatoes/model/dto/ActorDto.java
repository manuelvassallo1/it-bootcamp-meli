package com.meli.spoiledtomatoes.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ActorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Long favoriteMovieId;
}
