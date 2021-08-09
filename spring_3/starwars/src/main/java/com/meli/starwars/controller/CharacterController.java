package com.meli.starwars.controller;

import com.meli.starwars.model.CharacterDTO;
import com.meli.starwars.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CharacterController {

    private final CharacterService service;

    @GetMapping("/characters/{name}")
    public List<CharacterDTO> getCharacters(@PathVariable String name) {
        return service.getCharacters(name);
    }
}
