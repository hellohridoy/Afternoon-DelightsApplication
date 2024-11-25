package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.FoodOrder;
import com.example.Afternoon.Delights.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/food-orders")
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    // Create a new FoodOrder
    @PostMapping
    public FoodOrder createFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.saveFoodOrder(foodOrder);
    }

    // Get orders for a specific date
    @GetMapping("/{date}")
    public List<FoodOrder> getOrdersByDate(@PathVariable String date) {
        return foodOrderService.getOrdersByDate(date);
    }

    // Get all orders grouped by date
    @GetMapping("/grouped")
    public Map<String, List<FoodOrder>> getOrdersGroupedByDate() {
        return foodOrderService.getOrdersGroupedByDate();
    }
}
