package com.meli.spoiledtomatoes.service.impl;

import com.meli.spoiledtomatoes.model.dto.MovieDto;
import com.meli.spoiledtomatoes.model.mapper.MovieMapper;
import com.meli.spoiledtomatoes.repository.IMovieRepository;
import com.meli.spoiledtomatoes.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    private final IMovieRepository repository;

    @Override
    public List<MovieDto> getAllByActorGreaterRating(Double rating) {
        return MovieMapper.toMoviesDto(repository.findAllByActorsRatingGreaterThan(rating));
    }

    @Override
    public List<MovieDto> getAllByGenreName(String name) {
        return MovieMapper.toMoviesDto(repository.findAllByGenreNameContainsIgnoreCase(name));
    }
}
