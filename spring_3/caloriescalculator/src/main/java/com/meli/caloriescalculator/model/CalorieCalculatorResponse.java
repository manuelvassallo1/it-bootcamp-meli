package com.meli.caloriescalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalorieCalculatorResponse {
    private List<PlateDTO> plates;
    private IngredientDTO mostCaloricIngredient;
}
