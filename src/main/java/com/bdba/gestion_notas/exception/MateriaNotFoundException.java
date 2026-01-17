package com.bdba.gestion_notas.exception;

public class MateriaNotFoundException extends RuntimeException {
    private final String errorCode;

    public MateriaNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
