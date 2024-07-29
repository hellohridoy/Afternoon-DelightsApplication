package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.repository.BalanceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceHistoryService {
    @Autowired
    private BalanceHistoryRepository balanceHistoryRepository;

    public List<BalanceHistory> getAllBalance() {
        return balanceHistoryRepository.findAll();
    }

    public BalanceHistory saveBalanceHistory(String pin, Double amount) {
        BalanceHistory balanceHistory = new BalanceHistory();
        balanceHistory.setPin(pin);
        balanceHistory.setAmount(amount);
        return balanceHistoryRepository.save(balanceHistory);
    }

    public Optional<BalanceHistory> getBalanceHistoryByPin(Long id) {
        return balanceHistoryRepository.findById(id);
    }
    public List<Double> getAmountsByPin(Long id) {
        return balanceHistoryRepository.findAmountsById(id);
    }
}