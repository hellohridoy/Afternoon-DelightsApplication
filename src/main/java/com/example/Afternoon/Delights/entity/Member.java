package com.example.Afternoon.Delights.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "members", uniqueConstraints = {@UniqueConstraint(columnNames = "pin")})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Pin is required")
    @Column(unique = true, nullable = false)
    private String pin;

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    private String officialPhoneNumber;

    private String designation;

    private String departments;

    private String unit;

    private Integer activeStatus;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Double addInitialBalance;

    @Lob
    private byte[] profilePicture;

    // One-to-many relationship with Balance
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Balance> balances;

    // One-to-many relationship with DailyMeal
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DailyMeal> meals;
}
