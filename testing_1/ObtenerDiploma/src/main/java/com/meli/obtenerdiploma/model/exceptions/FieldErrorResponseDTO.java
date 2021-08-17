package com.meli.obtenerdiploma.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FieldErrorResponseDTO {
    private List<FieldErrorDTO> fieldErrors;
}