package com.meli.spoiledtomatoes.service;

import com.meli.spoiledtomatoes.model.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> findAllByFirstNameAndLastName(String firstName, String lastName);
}
