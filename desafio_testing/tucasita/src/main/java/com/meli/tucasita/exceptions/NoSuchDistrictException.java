package com.meli.tucasita.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchDistrictException extends PropertyException {
    private static final long serialVersionUID = -5372465917556619761L;

    public NoSuchDistrictException(String districtName) {
        super("El barrio " + districtName + " no existe.", HttpStatus.BAD_REQUEST);
    }
}
