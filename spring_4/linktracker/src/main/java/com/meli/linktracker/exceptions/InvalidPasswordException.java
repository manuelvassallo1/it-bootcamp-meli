package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends LinkTrackerException {
    private static final long serialVersionUID = 1309795842354352060L;

    public InvalidPasswordException() {
        super("La password es invalida.", HttpStatus.FORBIDDEN);
    }
}