package com.gl.restservice.service;

import com.gl.restservice.dto.request.PersonaDto;
import com.gl.restservice.repository.entity.PersonaEntity;
import com.gl.restservice.repository.entity.TelefonoEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PersonaToPersonaEntity implements Converter<PersonaDto, PersonaEntity> {

    @Value("${app.secret}")
    private String secreto;

    @Override
    public PersonaEntity convert(PersonaDto personaDto) {

        PersonaEntity personaEntity = new PersonaEntity();

        if(Objects.nonNull(personaDto.getId())){
            personaEntity.setId(personaDto.getId());
        }

        personaEntity.setName(personaDto.getName());
        personaEntity.setEmail(personaDto.getEmail());
        personaEntity.setPassword(personaDto.getPassword());
        personaEntity.setToken(Jwts.builder()
                                .signWith(SignatureAlgorithm.HS512, secreto)
                                .setPayload(personaDto.getName())
                                .compact()); //TODO: llenar


        List<TelefonoEntity> telefonoEntities = personaDto.getPhones().stream()
                .map(telefonoDto -> {
                    TelefonoEntity telefonoEntity = new TelefonoEntity();
                    telefonoEntity.setCityCode(telefonoDto.getCityCode());
                    telefonoEntity.setCountryCode(telefonoDto.getCountryCode());
                    telefonoEntity.setNumber(telefonoDto.getNumber());
                    telefonoEntity.setPersona(personaEntity);
                    return telefonoEntity;
                })
                .collect(Collectors.toList());

        personaEntity.setPhones(telefonoEntities);

        return personaEntity;
    }
}
