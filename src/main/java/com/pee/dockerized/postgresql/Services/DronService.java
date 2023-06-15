package com.pee.dockerized.postgresql.Services;

import java.util.List;

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Model.TipoDron;

public interface DronService {

    public Dron add(Dron e);
    public List<Dron> findAll();
    public Dron findById(long Id);
    public List<Dron> findByTipoDron(TipoDron tipoDron);
    public boolean delete(Long id);
    
}
