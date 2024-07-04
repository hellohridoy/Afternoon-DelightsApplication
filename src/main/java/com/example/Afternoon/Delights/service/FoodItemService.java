package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    public FoodItem save(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }
}