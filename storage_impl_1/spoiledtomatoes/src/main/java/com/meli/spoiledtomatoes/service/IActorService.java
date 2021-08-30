package com.meli.spoiledtomatoes.service;

import com.meli.spoiledtomatoes.model.dto.ActorDto;

import java.util.List;

public interface IActorService {

    List<ActorDto> getAllByFavoriteMovieNotNull();

    List<ActorDto> getAllGreaterRating(Double rating);

    List<ActorDto> getAllByMovieTitle(String title);
}
