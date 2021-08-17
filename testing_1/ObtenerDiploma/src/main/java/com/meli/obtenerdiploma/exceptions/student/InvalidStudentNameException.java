package com.meli.obtenerdiploma.exceptions.student;

import com.meli.obtenerdiploma.exceptions.StudentException;
import org.springframework.http.HttpStatus;

public class InvalidStudentNameException extends StudentException {
    private static final long serialVersionUID = 1235451843567858573L;

    public InvalidStudentNameException(String msg) {
        super(msg, HttpStatus.BAD_REQUEST);
    }
}
