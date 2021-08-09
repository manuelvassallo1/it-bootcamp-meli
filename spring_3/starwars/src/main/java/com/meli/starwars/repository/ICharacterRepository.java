package com.meli.starwars.repository;

import com.meli.starwars.model.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterDTO> getCharactersByName(String name);
}
