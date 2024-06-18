package com.example.Afternoon.Delights.controller;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.Afternoon.Delights.entity.User;
import com.example.Afternoon.Delights.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET all users (accessible to admin)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET user by ID (accessible to admin)
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // POST create a new user (accessible to admin)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // PUT update user info (accessible to admin)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setName(updatedUser.getName());
                    // Update other fields as needed
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    // DELETE user by ID (accessible to admin)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
