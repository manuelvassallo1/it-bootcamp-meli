package com.meli.caloriescalculator.repository;

import com.meli.caloriescalculator.model.IngredientDTO;

import java.util.NoSuchElementException;

public interface IIngredientRepository {
    IngredientDTO getIngredient(IngredientDTO ingredientDTO) throws NoSuchElementException;
}
