package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.DailyMealDetailsDTO;

import java.util.List;

public class DailyMealDetailsService {

    public List<DailyMealDetailsDTO> dailyMealDetailsDTOS;

    public List<DailyMealDetailsDTO> getDailyMealsDetails() {
        return dailyMealDetailsDTOS;
    }
}
