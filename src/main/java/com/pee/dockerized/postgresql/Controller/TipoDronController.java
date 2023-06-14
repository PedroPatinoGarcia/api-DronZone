package com.pee.dockerized.postgresql.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.TipoDron;
import com.pee.dockerized.postgresql.Services.TipoDronService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipoDron")
public class TipoDronController {

    @Autowired
    private TipoDronService tipoDronService;

    @GetMapping("")
    public List<TipoDron> getAllDroneType() {
        return tipoDronService.findAll();
    }

    @GetMapping("/{id}")
    public TipoDron getDroneTypeById(@PathVariable Long id) {
        return tipoDronService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> newElement(@Validated @RequestBody TipoDron nuevoTipoDron) {
        TipoDron categoria = tipoDronService.add(nuevoTipoDron);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria); // cod 201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        tipoDronService.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

}
