package com.gl.restservice.controller;

import com.gl.restservice.dto.request.PersonaDto;
import com.gl.restservice.dto.response.ResponseDto;
import com.gl.restservice.service.Servicio;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
@Validated
public class Controlador {

    private final Servicio servicio;

    public Controlador (Servicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping(path = "/new",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDto newPerson(@RequestBody @Valid PersonaDto personaDto) {
        return servicio.persistirPersona(personaDto);
    }
}
