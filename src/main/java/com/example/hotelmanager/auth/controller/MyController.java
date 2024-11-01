package com.example.hotelmanager.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/v1/authorizations")
public class MyController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String getAdmin() {
        return "Admin content thanh";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('user')")
    public String userEndpoint() {
        return "User content hung ";
    }
}
