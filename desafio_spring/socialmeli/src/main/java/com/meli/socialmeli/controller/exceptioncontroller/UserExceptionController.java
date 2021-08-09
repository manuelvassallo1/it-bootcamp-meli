package com.meli.socialmeli.controller.exceptioncontroller;

import com.meli.socialmeli.exceptions.UserException;
import com.meli.socialmeli.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(UserException.class)
    protected ResponseEntity<ErrorDTO> userExceptionHandler(UserException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getError(), e.getStatusCode());
    }

}
