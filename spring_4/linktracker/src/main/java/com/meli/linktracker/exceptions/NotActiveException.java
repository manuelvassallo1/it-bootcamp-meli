package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class NotActiveException extends LinkTrackerException {

    private static final long serialVersionUID = -8383429091486546158L;

    public NotActiveException(Integer id) {
        super("El link con ID: " + id + " se encuentra inactivo.", HttpStatus.BAD_REQUEST);
    }

}