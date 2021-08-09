package com.meli.socialmeli.exceptions.post;

import com.meli.socialmeli.exceptions.PostException;
import org.springframework.http.HttpStatus;

public class PostsNotFound extends PostException {
    private static final long serialVersionUID = 2270010087295134460L;

    public PostsNotFound() {
        super("No se han encontrado posts de este usuario.", HttpStatus.BAD_REQUEST);
    }

    public PostsNotFound(Integer userId) {
        super("No se han encontrado posts de los usuarios seguidos por el usuario con Id: " + userId,
                HttpStatus.BAD_REQUEST);
    }
}
