package com.pee.dockerized.postgresql.Services;

import java.util.List;

import com.pee.dockerized.postgresql.Model.Login;

public interface LoginService {

    public List<Login> findAll();
    public Login findById(long id);
}
