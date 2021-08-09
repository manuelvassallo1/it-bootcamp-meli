package com.meli.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiplomaDTO {
    private String msg;
    private Double avgScore;
    private StudentDTO studentDTO;
}
