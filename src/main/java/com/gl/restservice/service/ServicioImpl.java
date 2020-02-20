package com.gl.restservice.service;

import com.gl.restservice.configuration.exception.TecnicalErrorException;
import com.gl.restservice.repository.dao.PersonaRepository;
import com.gl.restservice.repository.entity.PersonaEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioImpl implements Servicio {

    private final PersonaRepository personaRepository;

    public ServicioImpl (PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void insertarPersona() {
        PersonaEntity personaEntity = personaRepository.findById(1L)
                                        .orElseThrow(() -> new TecnicalErrorException(""));

    }

}
