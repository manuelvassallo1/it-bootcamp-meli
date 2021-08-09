package com.meli.linktracker.controller;

import com.meli.linktracker.exceptions.LinkTrackerException;
import com.meli.linktracker.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkTrakerExceptionController {
    @ExceptionHandler(LinkTrackerException.class)
    protected ResponseEntity<ErrorDTO> trackerExceptionHandler(LinkTrackerException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getError(), e.getStatusCode());
    }
}
