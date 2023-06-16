package com.pee.dockerized.postgresql.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ErrorController {
    
    @GetMapping("/accessError")
    public ResponseEntity<String> permissionError() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Error");
    }
}
