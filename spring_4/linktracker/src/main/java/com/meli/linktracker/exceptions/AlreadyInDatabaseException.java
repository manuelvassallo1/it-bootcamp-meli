package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyInDatabaseException extends LinkTrackerException {
    private static final long serialVersionUID = -6105072117526687629L;

    public AlreadyInDatabaseException(String url) {
        super("El link: " + url + " ya fue creado. No se puede duplicar", HttpStatus.BAD_REQUEST);
    }
}