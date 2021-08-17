package com.meli.tucasita.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorDTO {

    private String field;
    private String errorMessage;
    private Object rejectedValue;

    public FieldErrorDTO(FieldError fe) {
        field = fe.getField();
        errorMessage = fe.getDefaultMessage();
        rejectedValue = fe.getRejectedValue();
    }
}