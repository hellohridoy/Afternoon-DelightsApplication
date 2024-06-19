package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
