package com.pee.dockerized.postgresql.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pee.dockerized.postgresql.Model.TipoDron;
import com.pee.dockerized.postgresql.Repository.TipoDronRepository;

@Service
public class TipoDronServiceImplMem implements TipoDronService{
    
    @Autowired
    TipoDronRepository tipoDronRepository;

    public TipoDron add(TipoDron e) {
        tipoDronRepository.save(e);
        return e;
    }

    public List<TipoDron> findAll() {
        return tipoDronRepository.findAll();
    }

    public TipoDron findById(long id) {
        return tipoDronRepository.findById(id).orElse(null);
    }

    public boolean delete(Long id) {
        TipoDron e = this.findById(id);
        if (e != null) {
            tipoDronRepository.delete(e);
            return true;
        }
        return false;
    }
}
