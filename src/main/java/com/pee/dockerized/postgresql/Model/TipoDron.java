package com.pee.dockerized.postgresql.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class TipoDron {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String tipo;
    private Double latitud;
    private Double longitud;

    public TipoDron(String tipo, Double latitud, Double longitud) {
        this.tipo = tipo;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
