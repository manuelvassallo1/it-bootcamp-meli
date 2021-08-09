package com.meli.caloriescalculator.service;

import com.meli.caloriescalculator.model.CalorieCalculatorResponse;
import com.meli.caloriescalculator.model.IngredientDTO;
import com.meli.caloriescalculator.model.PlateDTO;
import com.meli.caloriescalculator.repository.IIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CalorieCalculatorService implements ICalorieCalculatorService {

    private final IIngredientRepository repository;
    private IngredientDTO mostCaloric;

    @Override
    public CalorieCalculatorResponse processPlates(List<PlateDTO> plateDTOS) {
        plateDTOS.forEach(this::calculateCalories);
        return new CalorieCalculatorResponse(plateDTOS, mostCaloric);
    }

    private void calculateCalories(PlateDTO plateDTO) {
        plateDTO.getIngredients().forEach(i -> {
            try {
                i.setCalories(getCaloriesByIngredient(i));
                checkMostCaloricIngredient(i);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        });
        double plateCalories = getTotalCaloriesByPlate(plateDTO.getIngredients());
        plateDTO.setTotalCalories(plateCalories);
    }

    private void checkMostCaloricIngredient(IngredientDTO i) {
        if (mostCaloric != null) {
            if (i.getCalories() > mostCaloric.getCalories()) {
                mostCaloric = i;
            }
        } else {
            mostCaloric = i;
        }
    }

    private double getCaloriesByIngredient(IngredientDTO ingredientDTO) throws NoSuchElementException {
        IngredientDTO ingredient = repository.getIngredient(ingredientDTO);
        return (ingredientDTO.getWeight() * ingredient.getCalories()) / 100;
    }

    private double getTotalCaloriesByPlate(List<IngredientDTO> ingredientDTOS) {
        return ingredientDTOS.stream()
                .map(IngredientDTO::getCalories)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
