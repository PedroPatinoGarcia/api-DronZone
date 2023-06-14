package com.pee.dockerized.postgresql.Services;

import java.util.List;

import com.pee.dockerized.postgresql.Model.TipoDron;

public interface TipoDronService {

    public TipoDron add(TipoDron e);
    public List<TipoDron> findAll();
    public TipoDron findById(long id);
    public boolean delete(Long id);
}
