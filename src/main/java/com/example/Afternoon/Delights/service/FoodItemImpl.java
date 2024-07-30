package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemImpl implements FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    public FoodItem save(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public Page<FoodItem> getFoodItems(int page, int size) {
        return foodItemRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Double getTotalCostByDate(String date) {
        Double totalCost = foodItemRepository.findTotalCostByDate(date);
        return totalCost != null ? totalCost : 0.0;
    }
}
