package com.meli.socialmeli.exceptions.user;

import com.meli.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends UserException {
    private static final long serialVersionUID = -1127390982776185948L;

    public UserAlreadyFollowedException(Integer u1, Integer u2) {
        super("El user con ID: " + u1 + " ya sigue al user con ID: " + u2, HttpStatus.BAD_REQUEST);
    }
}
