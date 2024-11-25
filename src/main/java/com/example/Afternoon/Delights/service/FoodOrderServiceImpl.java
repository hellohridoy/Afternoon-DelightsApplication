package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.FoodOrder;
import com.example.Afternoon.Delights.repository.FoodOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderServiceImpl(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    @Override
    public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public List<FoodOrder> getOrdersByDate(String date) {
        return foodOrderRepository.findByDate(date);
    }

    @Override
    public Map<String, List<FoodOrder>> getOrdersGroupedByDate() {
        List<FoodOrder> allOrders = foodOrderRepository.findAllOrders();
        return allOrders.stream()
                .collect(Collectors.groupingBy(FoodOrder::getDate));
    }
}
