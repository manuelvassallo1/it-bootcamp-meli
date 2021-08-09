package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.model.CharacterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CharacterRepository implements ICharacterRepository {

    private static final String PATH = "/Users/mvassallo/Documents/Workspaces/meli_bootcamp_w11/spring_3/starwars/src/main/resources/Spring - Clase 3 - starwars.json";
    private final List<CharacterDTO> characters;

    private CharacterRepository() {
        characters = readJson();
    }

    private List<CharacterDTO> readJson() {
        List<CharacterDTO> charactersDTOs = null;
        try {
            Path path = Paths.get(PATH);
            String json = new String(Files.readAllBytes(path));
            ObjectMapper mapper = new ObjectMapper();

            charactersDTOs = mapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charactersDTOs;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        return characters.stream()
                .filter(ch -> ch.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
