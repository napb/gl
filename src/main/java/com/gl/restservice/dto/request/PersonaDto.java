
package com.gl.restservice.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class PersonaDto {

    private Long id;

    @NotNull
    @Email(message = "email invalido")
    private String email;
    private String name;

    @NotNull
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,10}$", message = "password invalida")
    private String password;
    private List<TelefonoDto> phones;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TelefonoDto> getPhones() {
        return phones;
    }

    public void setPhones(List<TelefonoDto> phones) {
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
