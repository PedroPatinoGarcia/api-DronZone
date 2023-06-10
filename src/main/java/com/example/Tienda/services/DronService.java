package com.example.Tienda.services;

import java.util.List;

import javax.validation.Valid;

import com.example.Tienda.domain.Dron;

public interface DronService {
    List<Dron> findAll();
    Dron findById(Long id);
    static Dron add(@Valid Dron nuevoDron) {
        return null;
    }
}
