package com.example.Afternoon.Delights.controller;


import com.example.Afternoon.Delights.entity.Admin;
import com.example.Afternoon.Delights.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Admin login - POST request
    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody Admin admin) {
        Admin storedAdmin = adminRepository.findByUsername(admin.getUsername());
        if (storedAdmin != null && storedAdmin.getPassword().equals(admin.getPassword())) {
            return ResponseEntity.ok("Admin login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin credentials");
        }
    }

    // Admin registration - POST request (for testing purposes)
    @PostMapping("/register")
    public ResponseEntity<String> adminRegister(@RequestBody Admin admin) {
        Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());
        if (existingAdmin != null) {
            return ResponseEntity.badRequest().body("Admin with username already exists");
        }
        adminRepository.save(admin);
        return ResponseEntity.ok("Admin registered successfully");
    }
}