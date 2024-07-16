package com.example.Afternoon.Delights.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pin;

    private String name;

    private String email;

    private String officialPhoneNumber;

    private String designation;

    private String departments;

    private String unit;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Double addInitialValance;
    @Lob
    private byte[] profilePicture;




}
