package com.pee.dockerized.postgresql.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ErrorController {
    
    @GetMapping("/accessError")
    public String permisionError(){
        return("accessError");
    }
}
