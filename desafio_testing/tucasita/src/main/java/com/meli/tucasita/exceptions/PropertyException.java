package com.meli.tucasita.exceptions;

import com.meli.tucasita.exceptions.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyException extends RuntimeException {
    private static final long serialVersionUID = -3534759519755366572L;
    private final ErrorDTO error;
    private final HttpStatus statusCode;

    public PropertyException(String errorDescription, HttpStatus statusCode) {
        error = new ErrorDTO(getClass().getSimpleName(), errorDescription);
        this.statusCode = statusCode;
    }
}
