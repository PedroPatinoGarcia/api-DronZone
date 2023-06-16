package com.pee.dockerized.postgresql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.Usuario;
import com.pee.dockerized.postgresql.Services.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public ResponseEntity<Usuario> leer(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build(); //
    }
}
