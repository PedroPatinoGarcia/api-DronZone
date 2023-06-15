package com.pee.dockerized.postgresql.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormInfo {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String latitud;
    @NotEmpty
    private String longitud;
    @Size(max = 256)
    private String comentarios;
    @AssertTrue
    private boolean aceptarCondiciones;
    @NotEmpty
    private String username;
    @NotEmpty
    private String roles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public boolean isAceptarCondiciones() {
        return aceptarCondiciones;
    }

    public void setAceptarCondiciones(boolean aceptarCondiciones) {
        this.aceptarCondiciones = aceptarCondiciones;
    }

}
