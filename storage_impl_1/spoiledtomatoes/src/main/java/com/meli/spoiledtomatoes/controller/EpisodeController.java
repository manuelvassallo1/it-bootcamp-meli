package com.meli.spoiledtomatoes.controller;

import com.meli.spoiledtomatoes.model.dto.EpisodeDto;
import com.meli.spoiledtomatoes.service.IEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoiledtomatoes/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final IEpisodeService service;

    @GetMapping("/actor/{firstName}/{lastName}")
    public List<EpisodeDto> findAllByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return service.findAllByFirstNameAndLastName(firstName, lastName);
    }
}
