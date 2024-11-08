package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.repository.FoodItemRepository;
import com.example.Afternoon.Delights.service.BalanceServiceImpl;
import com.example.Afternoon.Delights.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/food-items")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class FoodItemController {


    @Autowired
    FoodItemRepository foodItemRepository;

    @Autowired
    private FoodItemService foodItemService;
    @Autowired
    private BalanceServiceImpl balanceServiceImpl;

    @GetMapping("/get-item-cost")
    public List<FoodItem> findAll() {
        return foodItemService.findAll();
    }

    @PostMapping("/save-item-cost")
    public FoodItem save(@RequestBody FoodItem foodItem) {
        return foodItemService.save(foodItem);
    }

    @GetMapping("/paginated-food-items")
    public Page<FoodItem> getFoodItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {
        return foodItemService.getFoodItems(page, size);
    }

    @GetMapping("/totalCost")
    public Map<String, Double> getTotalCost(@RequestParam String date) {
        Double totalAmount = foodItemService.getTotalCostByDate(date);
        Map<String, Double> response = new HashMap<>();
        response.put("totalForDate", totalAmount != null ? totalAmount : 0.0);
        return response;
    }


}
