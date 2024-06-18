package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.BalanceType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pin;

    private Double balance;

    BalanceType balanceType;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
