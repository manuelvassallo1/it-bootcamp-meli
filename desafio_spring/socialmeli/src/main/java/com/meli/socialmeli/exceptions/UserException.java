package com.meli.socialmeli.exceptions;

import com.meli.socialmeli.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException {
    private static final long serialVersionUID = -3435686288929733856L;
    private final ErrorDTO error;
    private final HttpStatus statusCode;

    public UserException(String errorDescription, HttpStatus statusCode) {
        error = new ErrorDTO(getClass().getSimpleName(), errorDescription);
        this.statusCode = statusCode;
    }
}
