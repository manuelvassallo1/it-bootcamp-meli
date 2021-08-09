package com.meli.socialmeli.exceptions.user;

import com.meli.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;

public class SameUserException extends UserException {
    private static final long serialVersionUID = -4493730754264324700L;

    public SameUserException() {
        super("Los ID de usuario son iguales", HttpStatus.BAD_REQUEST);
    }
}
