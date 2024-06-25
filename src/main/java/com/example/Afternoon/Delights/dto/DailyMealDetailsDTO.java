package com.example.Afternoon.Delights.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class DailyMealDetailsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Timestamp startData;

    public Timestamp endData;

    public String description;

    public Double price;

    public String pin;

}
