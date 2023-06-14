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

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Services.DronService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dron")
public class DronController {

    @Autowired
    private DronService dronService;

    @GetMapping("")
    public List<Dron> getAllDrone() {
        return dronService.findAll();
    }

    @GetMapping("/{id}")
    public Dron getDroneById (@PathVariable Long id) {
        return dronService.findById(id);
    }

   @PostMapping("")
    public ResponseEntity<?> newElement(@Validated @RequestBody Dron nuevoDron) {
        Dron dron = dronService.add(nuevoDron);
        return ResponseEntity.status(HttpStatus.CREATED).body(dron); // cod 201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
            dronService.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }
    
}
