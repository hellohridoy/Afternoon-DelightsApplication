package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.FoodOrder;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.BalanceRepository;
import com.example.Afternoon.Delights.repository.FoodOrderRepository;
import com.example.Afternoon.Delights.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final BalanceRepository balanceRepository;
    private final MemberRepository memberRepository;

    public FoodOrderServiceImpl(FoodOrderRepository foodOrderRepository, BalanceRepository balanceRepository, MemberRepository memberRepository) {
        this.foodOrderRepository = foodOrderRepository;
        this.balanceRepository = balanceRepository;
        this.memberRepository = memberRepository;
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

    @Transactional
    @Override
    public FoodOrder updateFoodOrder(Long id, FoodOrder foodOrder) {
        if (foodOrder.getPins() != null && !foodOrder.getPins().isEmpty()) {
            double amountPerMember = foodOrder.getTotalCost() / foodOrder.getPins().size();

            Map<String, Double> memberCostMap = new HashMap<>();
            for (String pin : foodOrder.getPins()) {
                memberCostMap.put(pin, amountPerMember);

                Optional<Member> member = memberRepository.findByPin(pin);
                if (member.isEmpty()) {
                    throw new IllegalArgumentException("Invalid PIN: " + pin);
                }

                Optional<Balance> existingBalance = balanceRepository.findByPin(pin);
                Balance newBalance = new Balance();
                newBalance.setPin(pin);
                newBalance.setBalanceAmount(amountPerMember);
                newBalance.setBalanceType(BalanceType.ADD); // Adjust as needed
                balanceRepository.save(newBalance);
            }

            foodOrder.setAmountPerMember(memberCostMap);
        }

        return foodOrderRepository.save(foodOrder);
    }

    // In your service class
    public void updateFoodOrder(Long id, Double totalCost, List<String> pins) {
        // Implementation remains the same as before
        // You can update the food order based on id, totalCost, and pins
        Long updatedRows = foodOrderRepository.updateFoodOrder(id, totalCost, pins);
        if (updatedRows == 0) {
            throw new RuntimeException("FoodOrder with ID " + id + " not found or update failed.");
        }
    }

}
