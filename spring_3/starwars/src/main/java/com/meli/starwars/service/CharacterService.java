package com.meli.starwars.service;

import com.meli.starwars.model.CharacterDTO;
import com.meli.starwars.repository.ICharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CharacterService implements ICharacterService {

    private final ICharacterRepository repository;

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        return repository.getCharactersByName(name);
    }
}
