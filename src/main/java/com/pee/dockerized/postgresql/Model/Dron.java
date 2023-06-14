package com.pee.dockerized.postgresql.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @ManyToOne
    @JoinColumn(name = "tipodron")
    private TipoDron tipoDron;
    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
    @NotEmpty
    private Double latitud;
    private Double longitud;

    public Dron(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.latitud = latitud;
    }
}