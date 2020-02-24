package com.gl.restservice.repository.dao;

import com.gl.restservice.repository.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    PersonaEntity findByName(String name);

}
