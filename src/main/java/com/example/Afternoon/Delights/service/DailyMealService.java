package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.DailyMealDetailsDTO;
import com.example.Afternoon.Delights.entity.DailyMeal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DailyMealService {

    public List<DailyMeal> getAllDailyMeals();

    public Optional<DailyMeal> getDailyMealById(Long id);

    public DailyMeal addMeal(DailyMeal dailyMeal);

    DailyMeal addMeal(DailyMealDetailsDTO dailyMealDetailsDTO);

    public DailyMeal updateMeal(Long id, DailyMeal dailyMeal);

    public void deleteMeal(Long id);
}
