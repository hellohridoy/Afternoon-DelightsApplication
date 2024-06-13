package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.DailyMeal;

import java.util.List;
import java.util.Optional;

public interface DailyMealService {

    public List<DailyMeal> getAllDailyMeals();

    public Optional<DailyMeal> getDailyMealById(Long id);

    public DailyMeal addMeal(DailyMeal dailyMeal);

    public DailyMeal updateMeal(Long id,DailyMeal dailyMeal);

    public void deleteMeal(Long id);
}
