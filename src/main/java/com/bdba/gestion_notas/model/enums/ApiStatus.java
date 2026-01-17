package com.bdba.gestion_notas.model.enums;





public enum ApiStatus {
    OK(200, "Operación exitosa"),
    BAD_REQUEST(400, "Datos inválidos"),
    NOT_FOUND(404, "Recurso no encontrado"),
    INTERNAL_ERROR(500, "Error interno del servidor");

    private final int code;
    private final String message;

    ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
