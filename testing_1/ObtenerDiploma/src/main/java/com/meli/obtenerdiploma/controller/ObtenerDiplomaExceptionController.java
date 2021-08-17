package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exceptions.StudentException;
import com.meli.obtenerdiploma.model.exceptions.ErrorDTO;
import com.meli.obtenerdiploma.model.exceptions.FieldErrorDTO;
import com.meli.obtenerdiploma.model.exceptions.FieldErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<FieldErrorResponseDTO> handleHttpExceptions(MethodArgumentNotValidException e) {
        List<FieldErrorDTO> errorDescriptions = e.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldErrorDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new FieldErrorResponseDTO(errorDescriptions), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<FieldErrorDTO> handleHttpMessageExceptions(HttpMessageNotReadableException e) {
        FieldErrorDTO error = new FieldErrorDTO(e.getHttpInputMessage().toString(), e.getLocalizedMessage(), e.getCause());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentException.class)
    protected ResponseEntity<ErrorDTO> handleAPIExceptions(StudentException e) {
        return new ResponseEntity<>(e.getError(), e.getStatusCode());
    }


}
