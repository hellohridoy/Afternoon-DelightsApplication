package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.DailyMealDetailsDTO;
import com.example.Afternoon.Delights.repository.DailyMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyMealDetailsService {

    @Autowired
    DailyMealRepository dailyMealRepository;

    public List<DailyMealDetailsDTO> dailyMealDetailsDTOS;

    public List<DailyMealDetailsDTO> getDailyMealsDetails() {
        return dailyMealDetailsDTOS;
    }





}
