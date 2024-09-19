//package com.example.hotelmanager.auth.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.access.prepost.PreAuthorize;
//
//@RestController
//@RequestMapping("/api")
//public class MyController {
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('admin')")
//    public ResponseEntity<String> adminEndpoint() {
//        return ResponseEntity.ok("Admin content ") ;
//    }
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('user')")
//    public String userEndpoint() {
//        return "User content hung ";
//    }
//}
