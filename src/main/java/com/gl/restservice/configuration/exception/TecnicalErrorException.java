package com.gl.restservice.configuration.exception;

public class TecnicalErrorException extends RuntimeException {

    public TecnicalErrorException (String mensaje) {
        super(mensaje);
    }

    public TecnicalErrorException (String mensaje, Throwable throwable) {
        super(mensaje, throwable);
    }
}
