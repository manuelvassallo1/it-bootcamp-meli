package com.meli.starwars.service;

import com.meli.starwars.model.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getCharacters(String name);
}
