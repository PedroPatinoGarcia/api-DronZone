package dto;

import java.util.Map;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class FormInfo {
    @NotEmpty
    private String nombre;
    @NotEmpty @Email
    private String email;
    @NotEmpty
    private Map map;
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    @Size (max=256)
    private String comentarios;
    @AssertTrue
    private boolean aceptarCondiciones;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public boolean isAceptarCondiciones() {
        return aceptarCondiciones;
    }
    public void setAceptarCondiciones(boolean aceptarCondiciones) {
        this.aceptarCondiciones = aceptarCondiciones;
    }
}
