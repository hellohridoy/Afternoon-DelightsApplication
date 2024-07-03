package com.example.Afternoon.Delights.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

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

}
