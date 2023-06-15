package com.pee.dockerized.postgresql.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@EqualsAndHashCode(of = "id")
public class TipoDron {
    @Min(value = 0)
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String modelo;
    private Date fabricacion;
    private Double potencia;
    private Double precio;

    public TipoDron(@NotEmpty String modelo, Date fabricacion, Double potencia, Double precio) {
        this.modelo = modelo;
        this.fabricacion = fabricacion;
        this.potencia = potencia;
        this.precio = precio;
    }
}
