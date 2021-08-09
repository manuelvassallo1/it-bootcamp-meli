package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends LinkTrackerException {

    private static final long serialVersionUID = 1651419980818674093L;

    public NotFoundException(Integer id) {
        super("No existe un link creado con ID: " + id, HttpStatus.NOT_FOUND);
    }
}