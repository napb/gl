package com.gl.restservice.configuration;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.gl.restservice.controller"})
public class RestConfig {

    @ExceptionHandler(Exception.class)
    public Object interceptExceptions(){

        return null;
    }

}
