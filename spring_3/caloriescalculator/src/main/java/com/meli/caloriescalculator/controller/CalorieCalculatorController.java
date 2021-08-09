package com.meli.caloriescalculator.controller;

import com.meli.caloriescalculator.model.CalorieCalculatorResponse;
import com.meli.caloriescalculator.model.PlateDTO;
import com.meli.caloriescalculator.service.ICalorieCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CalorieCalculatorController {

    private final ICalorieCalculatorService service;

    @PostMapping("/calorieCalculator")
    public CalorieCalculatorResponse calculateCalories(@RequestBody List<PlateDTO> plateDTOS) {
        return service.processPlates(plateDTOS);
    }
}
