package com.gl.restservice.configuration;

import com.gl.restservice.configuration.exception.TecnicalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.gl.restservice.controller"})
public class RestConfigException {

    @ExceptionHandler(TecnicalErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto interceptTecnicalErrorException(TecnicalErrorException e){
        return new ErrorDto(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto interceptExceptions(Exception e){
        return new ErrorDto(e.getMessage());
    }

}
