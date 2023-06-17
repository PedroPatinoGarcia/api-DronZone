package com.pee.dockerized.postgresql.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Services.DronService;
import com.pee.dockerized.postgresql.Services.TipoDronService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dron")
public class DronController {
    @Autowired
    public DronService dronService;
    @Autowired
    public TipoDronService tipoDronService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({ "/", "" ,"/list"})
    public ResponseEntity<Map<String, Object>> getList() {
        Map<String, Object> response = new HashMap<>();
        response.put("listaDron", dronService.findAll());
        response.put("listaTipoDron", tipoDronService.findAll());
        response.put("tipoDronSeleccionada", "Todos");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list/{idCat}")
    public ResponseEntity<Map<String, Object>> showListInCategory(@PathVariable long idCat) {
        Map<String, Object> response = new HashMap<>();
        response.put("listaDrones", dronService.findByTipoDron(tipoDronService.findById(idCat)));
        response.put("listaTipoDron", tipoDronService.findAll());
        response.put("tipoDronSeleccionada", tipoDronService.findById(idCat).getModelo());
        return ResponseEntity.ok(response);
    } 
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/new")
    public ResponseEntity<Map<String, Object>> showNew() {
        Map<String, Object> response = new HashMap<>();
        response.put("dronForm", new Dron());
        response.put("listaTipoDron", tipoDronService.findAll());
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new/submit")
    public ResponseEntity<String> showNewSubmit(
            @Valid @ModelAttribute("dronForm") Dron nuevoDron,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().body("Error en los datos proporcionados");

        dronService.add(nuevoDron);
        return ResponseEntity.ok("Dron agregado correctamente");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> showDelete(@PathVariable long id) {
        dronService.delete(id);
        return ResponseEntity.ok("Dron eliminado correctamente");
    }

}
