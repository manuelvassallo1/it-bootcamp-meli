package com.meli.spoiledtomatoes.controller;

import com.meli.spoiledtomatoes.model.dto.MovieDto;
import com.meli.spoiledtomatoes.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoiledtomatoes/movies")
@RequiredArgsConstructor
public class MovieController {
    private final IMovieService service;

    @GetMapping("/greaterActorRating/{rating}")
    public List<MovieDto> getAllByActorGreaterRating(@PathVariable Double rating) {
        return service.getAllByActorGreaterRating(rating);
    }

    @GetMapping("/genre/{name}")
    public List<MovieDto> getAllByGenreName(@PathVariable String name) {
        return service.getAllByGenreName(name);
    }
}
