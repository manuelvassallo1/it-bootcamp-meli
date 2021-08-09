package com.meli.socialmeli.exceptions.user;

import com.meli.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;

public class UserNotFollowed extends UserException {
    private static final long serialVersionUID = 1235451843567858573L;

    public UserNotFollowed(Integer u1, Integer u2) {
        super("El user con ID: " + u1 + " no sigue al user con ID:" + u2, HttpStatus.BAD_REQUEST);
    }
}
