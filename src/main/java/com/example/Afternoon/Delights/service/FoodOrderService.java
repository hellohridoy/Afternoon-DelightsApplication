package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.FoodOrder;

import java.util.List;
import java.util.Map;

public interface FoodOrderService {
    FoodOrder saveFoodOrder(FoodOrder foodOrder);

    List<FoodOrder> getOrdersByDate(String date);

    Map<String, List<FoodOrder>> getOrdersGroupedByDate();
}
