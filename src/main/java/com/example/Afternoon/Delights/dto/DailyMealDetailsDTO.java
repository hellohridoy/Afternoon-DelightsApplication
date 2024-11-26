package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class DailyMealDetailsDTO {

    private String item;
    private Double price;
    private Double perHeadAmount;
    private BalanceType balanceType;

    @Data
    public static class ParticipantDTO {
        private String pin;
    }

}
