package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.exceptions.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StudentException extends RuntimeException {
    private static final long serialVersionUID = -3534759519755366572L;
    private final ErrorDTO error;
    private final HttpStatus statusCode;

    public StudentException(String errorDescription, HttpStatus statusCode) {
        error = new ErrorDTO(getClass().getSimpleName(), errorDescription);
        this.statusCode = statusCode;
    }
}
