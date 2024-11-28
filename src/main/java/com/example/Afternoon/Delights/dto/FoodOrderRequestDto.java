package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodOrderRequestDto {
    private String date;
    private String orderPin;
    private Double totalCost;
    private String foodItem;
    private List<String> pins; // Dynamic list of pins (strings)
}
