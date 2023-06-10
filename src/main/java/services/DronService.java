package services;

import java.util.List;

import javax.validation.Valid;

import domain.Dron;

public interface DronService {
    List<Dron> findAll();
    Dron findById(Long id);
    static Dron add(@Valid Dron nuevoDron) {
        return null;
    }
}
