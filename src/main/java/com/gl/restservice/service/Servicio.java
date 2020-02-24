package com.gl.restservice.service;

import com.gl.restservice.dto.request.PersonaDto;
import com.gl.restservice.dto.response.ResponseDto;

public interface Servicio {
    ResponseDto persistirPersona(PersonaDto personaDto);
}
