package com.example.Tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tienda.domain.Dron;
import com.example.Tienda.exceptions.DronNotFoundException;
import com.example.Tienda.repository.DronRepository;

@Service
public class DronServiceImpl implements DronService {
    private DronRepository dronRepository;

    @Autowired
    public DronServiceImpl(DronRepository dronRepository) {
        this.dronRepository = dronRepository;
    }

    @Override
    public List<Dron> findAll() {
        return dronRepository.findAll();
    }

    @Override
    public static Dron findById(Long id) {
        Dron dron = dronRepository.findById(id).orElseThrow(() -> new DronNotFoundException(id));
        return dron;
    }
}
