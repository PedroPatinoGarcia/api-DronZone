package com.pee.dockerized.postgresql.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Model.TipoDron;
import com.pee.dockerized.postgresql.Repository.DronRepository;


@Service
public class DronServiceImpl implements DronService{
    
    @Autowired
    DronRepository dronRepository;

    public Dron add(Dron e) {
        dronRepository.save(e);
        return e;
    }

    public List<Dron> findAll() {
        return dronRepository.findAll();
    }

    public Dron findById(long id) {
        return dronRepository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        Dron e = this.findById(id);
        if (e != null) {
            dronRepository.delete(e);
            return true;
        }
        return false;
    }
    public List<Dron> findByTipoDron(TipoDron tipoDron) {
        return dronRepository.findByTipoDron(tipoDron);
    }
}