package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class NotValidException extends LinkTrackerException {

    private static final long serialVersionUID = -578550081967356022L;

    public NotValidException(String url) {
        super("La url: " + url + " no es valida.", HttpStatus.BAD_REQUEST);
    }
}