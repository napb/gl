package com.gl.restservice.controller;

import com.gl.restservice.dto.request.PersonaDto;
import com.gl.restservice.service.Servicio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class Controlador {

    private final Servicio servicio;

    public Controlador (Servicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping(path = "/new",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void newPerson(@RequestBody PersonaDto personaDto) {
        System.out.println("acaaaaa");
        servicio.insertarPersona();
    }
}
