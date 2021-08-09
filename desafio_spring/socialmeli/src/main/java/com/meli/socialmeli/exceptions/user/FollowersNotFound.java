package com.meli.socialmeli.exceptions.user;

import com.meli.socialmeli.exceptions.UserException;
import org.springframework.http.HttpStatus;

public class FollowersNotFound extends UserException {
    private static final long serialVersionUID = 2131228560680963901L;

    public FollowersNotFound() {
        super("No se han encontrado seguidores.", HttpStatus.BAD_REQUEST);
    }
}
