package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.FoodOrder;
import com.example.Afternoon.Delights.service.FoodOrderService;
import com.example.Afternoon.Delights.service.FoodOrderServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
public class FoodOrderController {

    private final FoodOrderService foodOrderService;
    private final FoodOrderServiceImpl foodOrderServiceImpl;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService, FoodOrderServiceImpl foodOrderServiceImpl) {
        this.foodOrderService = foodOrderService;
        this.foodOrderServiceImpl = foodOrderServiceImpl;
    }

    // Create a new FoodOrder
    @PostMapping("/afternoon-delights/meal/meal-infos")
    public FoodOrder createFoodOrder(@RequestBody FoodOrder foodOrder) {
        return foodOrderService.saveFoodOrder(foodOrder);
    }

    // Get orders for a specific date
    @GetMapping("/afternoon-delights/daily-meal/meal-infos/{date}")
    public List<FoodOrder> getOrdersByDate(@PathVariable String date) {
        return foodOrderService.getOrdersByDate(date);
    }

    // Get all orders grouped by date
    @GetMapping("/afternoon-delights/daily-meal/meal-infos")
    public Map<String, List<FoodOrder>> getOrdersGroupedByDate() {
        return foodOrderService.getOrdersGroupedByDate();
    }




    @PutMapping("/food-order/update/{id}")
    public ResponseEntity<String> updateFoodOrder(@PathVariable Long id, @RequestBody FoodOrder foodOrder) {
        foodOrderServiceImpl.updateFoodOrder(id, foodOrder);
        return ResponseEntity.ok("Food order updated successfully");
    }


}
