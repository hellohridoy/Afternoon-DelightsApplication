package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.Role;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;
}