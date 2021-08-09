package com.meli.caloriescalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlateDTO {
    private String name;
    private List<IngredientDTO> ingredients;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double totalCalories;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private IngredientDTO mostCaloric;

}
