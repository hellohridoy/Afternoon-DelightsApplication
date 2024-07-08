package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.repository.FoodItemRepository;
import com.example.Afternoon.Delights.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/food-items")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class FoodItemController {
    @Autowired
    private FoodItemRepository foodItemRepository;

    @PostMapping
    public FoodItem saveFoodItem(@RequestBody FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @GetMapping
    public List<FoodItem> getFoodItems() {
        return foodItemRepository.findAll();
    }
}