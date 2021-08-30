package com.meli.spoiledtomatoes.model.mapper;

import com.meli.spoiledtomatoes.model.dto.ActorDto;
import com.meli.spoiledtomatoes.model.entity.Actor;
import com.meli.spoiledtomatoes.model.entity.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {
    public static ActorDto toActorDto(Actor actor) {
        Long movieId = null;
        Movie movie = actor.getFavoriteMovie();

        if (movie != null) {
            movieId = movie.getId();
        }
        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .favoriteMovieId(movieId)
                .build();
    }

    public static List<ActorDto> toActorsDto(List<Actor> actors) {
        return actors.stream()
                .map(ActorMapper::toActorDto)
                .collect(Collectors.toList());
    }
}
