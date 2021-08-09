package com.meli.socialmeli.controller.exceptioncontroller;

import com.meli.socialmeli.exceptions.PostException;
import com.meli.socialmeli.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(PostException.class)
    protected ResponseEntity<ErrorDTO> postExceptionHandler(PostException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getError(), e.getStatusCode());
    }

}
