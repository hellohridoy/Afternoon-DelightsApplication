package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}