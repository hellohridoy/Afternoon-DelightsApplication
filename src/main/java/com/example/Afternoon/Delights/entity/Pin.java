package com.example.Afternoon.Delights.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 4, nullable = false)
    private String pin;  // 4-digit unique pin for each employee

    // One-to-Many relationship with Detail
    @OneToMany(mappedBy = "pin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Detail> details;
}
