package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BalanceDTO {
    private Long id;
    private String pin;
    private Double balance;
    private BalanceType balanceType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
