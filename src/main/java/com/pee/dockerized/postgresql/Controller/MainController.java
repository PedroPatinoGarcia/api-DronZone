package com.pee.dockerized.postgresql.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.dto.FormInfo;

@RestController
@RequestMapping("")
public class MainController {
    

    @GetMapping({ "/", "/login", "/home" })
    public ResponseEntity<Map<String, Object>> getIndex(Model model, @RequestParam Optional<String> n) {
        Map<String, Object> response = new HashMap<>();
        response.put("nombre", n.orElse(""));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/maps")
    public ResponseEntity<Map<String, Object>> getContact(Model model) {
        Map<String, Object> response = new HashMap<>();
        response.put("formInfo", new FormInfo());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/maps**")
    public ResponseEntity<String> submitContact(@Valid FormInfo formInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body("Error en los datos proporcionados");
        else {
            return ResponseEntity.ok("Contacto enviado correctamente");
        }
    }

    @GetMapping("/coordenadas")
    public ResponseEntity<String> getCoordinates() {
        return ResponseEntity.ok("Coordenadas");
    }
}
