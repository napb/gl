package com.gl.restservice.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "telefono")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable=false)
    })
    private PersonaEntity persona;

    private String cityCode;
    private String countryCode;
    private String number;

}
