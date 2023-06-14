package com.pee.dockerized.postgresql.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;

public class FormInfo {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private Double latitud;
    @NotEmpty
    private Double longitud;
    @AssertTrue
    private boolean aceptarCondiciones;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public boolean isAceptarCondiciones() {
        return aceptarCondiciones;
    }
    public void setAceptarCondiciones(boolean aceptarCondiciones) {
        this.aceptarCondiciones = aceptarCondiciones;
    }
}

