package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FoodItemService {


    public List<FoodItem> findAll();



    public FoodItem save(FoodItem foodItem);


    public Page<FoodItem> getFoodItems(int page, int size);

    public Double getTotalCostByDate(String date);
}