package com.meli.tucasita.exceptions;

import org.springframework.http.HttpStatus;

public class WrongRoomsSizeException extends PropertyException {
    private static final long serialVersionUID = -7107378497103825995L;

    public WrongRoomsSizeException() {
        super("El area de los dormitorios no puede superar el area total de la propiedad.", HttpStatus.BAD_REQUEST);
    }
}
