package com.example.spring_security_june.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the app";
    }

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STUDENT')")
    public String welcomeStudent() {
        return "Welcome, STUDENT";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcomeAdmin() {
        return "Welcome, ADMIN!";
    }
}
