package com.meli.caloriescalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.caloriescalculator.model.IngredientDTO;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private static final String DB_PATH = "spring_3/caloriescalculator/src/main/resources/Spring - Clase 3 - food.json";
    private final List<IngredientDTO> ingredients;

    private IngredientRepository() {
        ingredients = readJson();
    }

    private List<IngredientDTO> readJson() {
        List<IngredientDTO> ingredientDTOS = null;
        try {
            Path path = Paths.get(DB_PATH);
            String json = new String(Files.readAllBytes(path));
            ObjectMapper mapper = new ObjectMapper();

            ingredientDTOS = mapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientDTOS;
    }

    @Override
    public IngredientDTO getIngredient(IngredientDTO ingredientDTO) throws NoSuchElementException {

        double calories = ingredients.stream()
                .filter(i -> i.getName().equals(ingredientDTO.getName()))
                .findAny()
                .orElseThrow()
                .getCalories();

        ingredientDTO.setCalories(calories);
        return ingredientDTO;
    }
}
