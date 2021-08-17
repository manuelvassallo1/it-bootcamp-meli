package com.meli.obtenerdiploma.exceptions.student;

import com.meli.obtenerdiploma.exceptions.StudentException;
import org.springframework.http.HttpStatus;

public class InvalidSubjectNameException extends StudentException {
    private static final long serialVersionUID = 2880780759071009796L;

    public InvalidSubjectNameException(String msg) {
        super(msg, HttpStatus.BAD_REQUEST);
    }
}
