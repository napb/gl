package com.gl.restservice.service;

import com.gl.restservice.configuration.exception.TecnicalErrorException;
import com.gl.restservice.dto.request.PersonaDto;
import com.gl.restservice.dto.response.ResponseDto;
import com.gl.restservice.repository.dao.PersonaRepository;
import com.gl.restservice.repository.entity.PersonaEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServicioImpl implements Servicio {

    private final ConversionService conversionService;
    private final PersonaRepository personaRepository;

    public ServicioImpl (ConversionService conversionService,
                         PersonaRepository personaRepository) {
        this.conversionService = conversionService;
        this.personaRepository = personaRepository;
    }

    @Override
    public ResponseDto persistirPersona(PersonaDto personaDto) {

        PersonaEntity personaEntity = Optional.ofNullable(personaRepository.findByName(personaDto.getName()))
                .map(perEntity -> {
                    if(perEntity.getEmail().equals(personaDto.getEmail())){
                        throw new TecnicalErrorException("El correo ya esta registrado");
                    }
                    personaDto.setId(perEntity.getId());
                    return conversionService.convert(personaDto, PersonaEntity.class);
                })
                .orElseGet(() -> conversionService.convert(personaDto, PersonaEntity.class));

        personaRepository.save(personaEntity);

        return null;
    }
}
