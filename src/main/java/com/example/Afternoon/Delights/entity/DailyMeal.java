package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.BalanceType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDate;
@Data
@Entity
public class DailyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    private String participants;

    private Double price;

    private Double perHeadAmount;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
