package com.meli.spoiledtomatoes.service.impl;

import com.meli.spoiledtomatoes.model.dto.ActorDto;
import com.meli.spoiledtomatoes.model.mapper.ActorMapper;
import com.meli.spoiledtomatoes.repository.IActorRepository;
import com.meli.spoiledtomatoes.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements IActorService {

    private final IActorRepository repository;

    @Override
    public List<ActorDto> getAllByFavoriteMovieNotNull() {
        return ActorMapper.toActorsDto(repository.findAllByFavoriteMovieIsNotNull());
    }

    @Override
    public List<ActorDto> getAllGreaterRating(Double rating) {
        return ActorMapper.toActorsDto(repository.findAllByRatingGreaterThan(rating));
    }

    @Override
    public List<ActorDto> getAllByMovieTitle(String title) {
        return ActorMapper.toActorsDto(repository.findAllByActedMoviesTitleContainsIgnoreCase(title));
    }
}
