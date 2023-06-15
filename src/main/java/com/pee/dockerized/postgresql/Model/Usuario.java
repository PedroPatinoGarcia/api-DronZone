package com.pee.dockerized.postgresql.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String username;
    private String password;
    private Rol rol;
    public Usuario(@NotEmpty String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
        public String getUsername() {
        return username;
    }
}