package com.meli.spoiledtomatoes.controller;

import com.meli.spoiledtomatoes.model.dto.ActorDto;
import com.meli.spoiledtomatoes.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spoiledtomatoes/actors")
@RequiredArgsConstructor
public class ActorController {
    private final IActorService service;

    @GetMapping("/getAll/favoriteMovie")
    public List<ActorDto> getAllByFavoriteMovieNotNull() {
        return service.getAllByFavoriteMovieNotNull();
    }

    @GetMapping("/greaterRating/{rating}")
    public List<ActorDto> getAllGreaterRating(@PathVariable Double rating) {
        return service.getAllGreaterRating(rating);
    }

    @GetMapping("/movie/{title}")
    public List<ActorDto> getAllByMovieTitle(@PathVariable String title) {
        return service.getAllByMovieTitle(title);
    }

}
