package com.meli.obtenerdiploma.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;


@Getter
@Setter
@AllArgsConstructor
public class FieldErrorDTO {

    private final String field;
    private final String errorMessage;
    private final Object rejectedValue;

    public FieldErrorDTO(FieldError fe) {
        field = fe.getField();
        errorMessage = fe.getDefaultMessage();
        rejectedValue = fe.getRejectedValue();
    }


}