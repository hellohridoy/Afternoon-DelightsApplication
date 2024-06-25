package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.UserAuth;
import com.example.Afternoon.Delights.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RestController
@RequestMapping("/api/users")

public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/register")
    public ResponseEntity<UserAuth> register(@RequestBody UserAuth userAuth) {
        userAuth.setRole("USER"); // Default role is USER
        UserAuth registeredUserAuth = userAuthService.register(userAuth);
        return ResponseEntity.ok(registeredUserAuth);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<UserAuth> registerAdmin(@RequestBody UserAuth userAuth) {
        userAuth.setRole("ADMIN"); // Role is ADMIN for admin registration
        UserAuth registeredUserAuth = userAuthService.register(userAuth);
        return ResponseEntity.ok(registeredUserAuth);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuth> login(@RequestBody UserAuth userAuth) {
        UserAuth loggedInUserAuth = userAuthService.login(userAuth.getUsername(), userAuth.getPassword());
        if (loggedInUserAuth != null) {
            return ResponseEntity.ok(loggedInUserAuth);
        }
        return ResponseEntity.status(401).build();
    }

    // Admin endpoints
    @GetMapping("/admin")
    public ResponseEntity<List<UserAuth>> getAllUsers() {
        List<UserAuth> userAuths = userAuthService.getAllUsers();
        return ResponseEntity.ok(userAuths);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<UserAuth> getUserById(@PathVariable Long id) {
        Optional<UserAuth> user = userAuthService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<UserAuth> updateUser(@PathVariable Long id, @RequestBody UserAuth userAuthDetails) {
        UserAuth updatedUserAuth = userAuthService.updateUser(id, userAuthDetails);
        if (updatedUserAuth != null) {
            return ResponseEntity.ok(updatedUserAuth);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAuthService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/admin/create")
    public ResponseEntity<UserAuth> createUser(@RequestBody UserAuth userAuth) {
        UserAuth createdUserAuth = userAuthService.register(userAuth);
        return ResponseEntity.ok(createdUserAuth);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserAuth> getProfile(@RequestParam String username) {
        UserAuth userAuth = userAuthService.findByUsername(username);
        if (userAuth != null) {
            return ResponseEntity.ok(userAuth);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/profile/addMoney")
    public ResponseEntity<UserAuth> addMoney(@RequestParam String username, @RequestParam Double amount) {
        UserAuth userAuth = userAuthService.findByUsername(username);
        if (userAuth != null) {
            if (userAuth.getMoney() == null) {
                userAuth.setMoney(0.0);
            }
            userAuth.setMoney(userAuth.getMoney() + amount);
            userAuthService.save(userAuth);
            return ResponseEntity.ok(userAuth);
        }
        return ResponseEntity.notFound().build();
    }

}