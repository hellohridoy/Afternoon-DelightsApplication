package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.service.DailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RequestMapping("/afternoon-delights/daily-meal")
@RestController
public class DailyMealController {

    @Autowired
    private DailyMealService dailyMealService;

    @GetMapping("/all")
    public List<DailyMeal> all() {
        return dailyMealService.getAllDailyMeals();
    }

    @GetMapping("/{id}")
    public Optional<DailyMeal> findById(@PathVariable Long id) {
        return dailyMealService.getDailyMealById(id);
    }

    @PostMapping("/add-meal")
    public DailyMeal addMeal(@RequestBody DailyMeal dailyMeal) {
        return dailyMealService.addMeal(dailyMeal);
    }

    @PutMapping("/{id}")
    public DailyMeal updateMeal(@PathVariable Long id, @RequestBody DailyMeal dailyMeal) {
        return dailyMealService.updateMeal(id, dailyMeal);
    }

    @DeleteMapping("/delete/{id}")
    public void  deleteMeal(@PathVariable Long id) {
        dailyMealService.deleteMeal(id);
    }
}
