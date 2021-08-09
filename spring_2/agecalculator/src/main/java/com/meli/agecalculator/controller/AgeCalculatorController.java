package com.meli.agecalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeCalculatorController {
    @GetMapping("/age/{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {

        LocalDate startDateInclusive = LocalDate.of(year, month, day);
        Period period = Period.between(startDateInclusive, LocalDate.now());

        return String.format("%d", period.getYears());
    }
}
