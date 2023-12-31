package com.pee.dockerized.postgresql.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
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
public class Dron {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nombre;
    private Double latitud;
    private Double longitud;

    @ManyToOne
    private TipoDron tipoDron; 

    public Dron(@NotEmpty String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}