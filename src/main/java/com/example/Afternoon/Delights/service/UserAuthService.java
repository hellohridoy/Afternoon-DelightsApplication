package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.UserAuth;
import com.example.Afternoon.Delights.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    public UserAuth register(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    public void save(UserAuth userAuth) {
        userAuthRepository.save(userAuth);
    }

    public UserAuth findByUsername(String username) {
        return userAuthRepository.findByUsername(username);
    }

    public UserAuth login(String username, String password) {
        UserAuth userAuth = userAuthRepository.findByUsername(username);
        if (userAuth != null && userAuth.getPassword().equals(password)) {
            return userAuth;
        }
        return null;
    }

    public List<UserAuth> getAllUsers() {
        return userAuthRepository.findAll();
    }

    public Optional<UserAuth> getUserById(Long id) {
        return userAuthRepository.findById(id);
    }

    public UserAuth updateUser(Long id, UserAuth userAuthDetails) {
        Optional<UserAuth> userOptional = userAuthRepository.findById(id);
        if (userOptional.isPresent()) {
            UserAuth userAuth = userOptional.get();
            userAuth.setUsername(userAuthDetails.getUsername());
            userAuth.setPassword(userAuthDetails.getPassword());
            userAuth.setRole(userAuthDetails.getRole());
            return userAuthRepository.save(userAuth);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userAuthRepository.deleteById(id);
    }
}