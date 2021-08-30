package com.meli.spoiledtomatoes.service.impl;

import com.meli.spoiledtomatoes.model.dto.EpisodeDto;
import com.meli.spoiledtomatoes.model.mapper.EpisodeMapper;
import com.meli.spoiledtomatoes.repository.IEpisodeRepository;
import com.meli.spoiledtomatoes.service.IEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService implements IEpisodeService {

    private final IEpisodeRepository repository;

    @Override
    public List<EpisodeDto> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return EpisodeMapper.toEpisodesDto(
                repository.findAllByActorsFirstNameContainsIgnoreCaseAndActorsLastNameContainsIgnoreCase(firstName, lastName));
    }
}
