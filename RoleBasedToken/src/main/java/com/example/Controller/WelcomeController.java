package com.example.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/get/welcome")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getMessage(){
        return "welcome to Admin";
    }
}
