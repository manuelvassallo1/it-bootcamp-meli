package com.meli.socialmeli.exceptions.user;

import com.meli.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    private static final long serialVersionUID = -377960591452853040L;

    public UserNotFoundException(Integer userId) {
        super("El user con ID: " + userId + " no fue encontrado.", HttpStatus.BAD_REQUEST);
    }
}
