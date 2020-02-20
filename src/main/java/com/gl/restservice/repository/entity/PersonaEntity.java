package com.gl.restservice.repository.entity;

import com.gl.restservice.dto.request.TelefonoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String email;
    private String name;
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id")
    private List<TelefonoEntity> phones;
}
