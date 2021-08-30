package com.meli.spoiledtomatoes.service;

import com.meli.spoiledtomatoes.model.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getAllByActorGreaterRating(Double rating);

    List<MovieDto> getAllByGenreName(String name);
}
