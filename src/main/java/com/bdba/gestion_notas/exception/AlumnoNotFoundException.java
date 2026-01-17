package com.bdba.gestion_notas.exception;

import lombok.Getter;

@Getter
public class AlumnoNotFoundException extends RuntimeException{
    private final String errorCode;

    public AlumnoNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
