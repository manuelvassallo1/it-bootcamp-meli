package com.meli.caloriescalculator.service;

import com.meli.caloriescalculator.model.CalorieCalculatorResponse;
import com.meli.caloriescalculator.model.PlateDTO;

import java.util.List;

public interface ICalorieCalculatorService {
    CalorieCalculatorResponse processPlates(List<PlateDTO> plateDTOS);
}
