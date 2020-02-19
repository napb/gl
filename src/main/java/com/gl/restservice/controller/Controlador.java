package com.gl.restservice.controller;

import com.gl.restservice.dto.request.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class Controlador {

    public Controlador () {

    }

    @PostMapping("/new")
    public void newPerson(@RequestParam Person person){

    }
}
