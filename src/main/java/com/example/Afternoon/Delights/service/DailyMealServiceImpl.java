package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.repository.DailyMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyMealServiceImpl implements DailyMealService {

    @Autowired
    private DailyMealRepository dailyMealRepository;

    public List<DailyMeal> getAllDailyMeals(){
        return dailyMealRepository.findAll();
    }

    public Optional<DailyMeal> getDailyMealById(Long id){
        return dailyMealRepository.findById(id);
    }

    public DailyMeal addMeal(DailyMeal dailyMeal){
        return dailyMealRepository.save(dailyMeal);
    }

    public DailyMeal updateMeal(Long id,DailyMeal dailyMeal){
            return dailyMealRepository.save(dailyMeal);

    }

    public void deleteMeal(Long id){
        dailyMealRepository.deleteById(id);
    }
}
