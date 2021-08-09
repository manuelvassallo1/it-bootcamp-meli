package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyActiveException extends LinkTrackerException {

    private static final long serialVersionUID = 3291860047179461332L;

    public AlreadyActiveException(Integer id) {
        super("El link con ID: " + id + " ya se encuentra activo actualmente.", HttpStatus.BAD_REQUEST);
    }
}
