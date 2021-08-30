package com.meli.spoiledtomatoes.controller;

import com.meli.spoiledtomatoes.model.dto.SerieDto;
import com.meli.spoiledtomatoes.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoiledtomatoes/series")
@RequiredArgsConstructor
public class SerieController {
    private final ISerieService service;

    @GetMapping("/greaterSeasonsCount/{seasonsCount}")
    public List<SerieDto> getAllByActorGreaterRating(@PathVariable Integer seasonsCount) {
        return service.findAllBySeasonsCountGreaterThan(seasonsCount);
    }
}
