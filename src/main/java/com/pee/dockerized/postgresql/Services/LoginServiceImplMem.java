package com.pee.dockerized.postgresql.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pee.dockerized.postgresql.Model.Login;
import com.pee.dockerized.postgresql.Repository.LoginRepository;

@Service
public class LoginServiceImplMem implements LoginService{
    
    @Autowired
    LoginRepository loginRepository;

    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public Login findById(long id) {
        return loginRepository.findById(id).orElse(null);
    }
}
