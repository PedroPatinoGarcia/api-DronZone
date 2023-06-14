package com.pee.dockerized.postgresql.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "nombre")
@Entity
public class Login {
    @Id
    private String nombre;
    @NotEmpty
    private String contraseña;

    public Login(String contraseña) {
        this.contraseña = contraseña;
    }
}
