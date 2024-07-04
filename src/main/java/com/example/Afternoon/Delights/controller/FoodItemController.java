package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItem> findAll() {
        return foodItemService.findAll();
    }

    @PostMapping
    public FoodItem save(@RequestBody FoodItem foodItem) {
        return foodItemService.save(foodItem);
    }
}