package com.example.Tienda.restController;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tienda.domain.Dron;
import com.example.Tienda.services.DronServices;

@RestController
@RequestMapping("/api/map")
public class MapRestController {

    @GetMapping("")
    public String showMap() {
        StringBuilder mapBuilder = new StringBuilder();
        mapBuilder.append("Map content goes here\n");
        mapBuilder.append("Drones:\n");
        return mapBuilder.toString();
    }

    @GetMapping("/drones{id}")
    public Dron getDroneById(@PathVariable Long id) {
        return DronServices.findById(id);
    }


    @PostMapping("")
    public ResponseEntity<?> newElement(@Valid @RequestBody Dron nuevoDron) {
        Dron dron = DronServices.add(nuevoDron);
        return ResponseEntity.status(HttpStatus.CREATED).body(dron); // cod 201
    }

}
