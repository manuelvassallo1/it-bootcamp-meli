package com.meli.linktracker.exceptions;

import com.meli.linktracker.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LinkTrackerException extends RuntimeException {

    private static final long serialVersionUID = 1870558235429418078L;
    private final ErrorDTO error;
    private final HttpStatus statusCode;

    public LinkTrackerException(String errorDescription, HttpStatus statusCode) {
        error = new ErrorDTO(getClass().getSimpleName(), errorDescription);
        this.statusCode = statusCode;
    }

}