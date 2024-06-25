package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.dto.DailyMealDetailsDTO;
import com.example.Afternoon.Delights.entity.UserAuth;
import com.example.Afternoon.Delights.service.DailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
@RestController
@RequestMapping("/afternoon-delights/daily-meal")
public class DailyMealDetailsController {

    @Autowired
    private DailyMealService dailyMealService;

    @GetMapping("/daily-meal-details")
    public ResponseEntity<DailyMealDetailsDTO> getDailyMealsDetails(@RequestParam Timestamp startDate, @RequestParam Timestamp endDate) {
       return null;
    }
}
