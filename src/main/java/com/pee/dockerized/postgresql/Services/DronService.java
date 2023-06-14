package com.pee.dockerized.postgresql.Services;

import java.util.List;

import com.pee.dockerized.postgresql.Model.Dron;

public interface DronService {

    public Dron add(Dron e);
    public List<Dron> findAll();
    public Dron findById(long id);
    public boolean delete(Long id);
    
}
