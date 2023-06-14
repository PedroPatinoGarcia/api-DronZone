package com.pee.dockerized.postgresql.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.Login;
import com.pee.dockerized.postgresql.Services.LoginService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public List<Login> getAllLogin() {
        return loginService.findAll();
    }

    @GetMapping("/{id}")
    public Login getLoginById (@PathVariable Long id) {
        return loginService.findById(id);
    }
    
}
