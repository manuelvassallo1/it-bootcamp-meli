package com.meli.spoiledtomatoes.controller;

import com.meli.spoiledtomatoes.model.dto.SeasonDto;
import com.meli.spoiledtomatoes.service.ISeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoiledtomatoes/seasons")
@RequiredArgsConstructor
public class SeasonController {
    private final ISeasonService service;

    @GetMapping("/genre/{genreName}")
    public List<SeasonDto> getAllBySerieGenre(@PathVariable String genreName) {
        return service.findAllBySerieGenre(genreName);
    }
}
