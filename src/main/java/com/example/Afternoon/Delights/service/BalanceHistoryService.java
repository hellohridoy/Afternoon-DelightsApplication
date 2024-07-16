package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.repository.BalanceHistoryRepository;
import com.example.Afternoon.Delights.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BalanceHistoryService {
    @Autowired
    private BalanceHistoryRepository balanceHistoryRepository;

    public BalanceHistory saveBalanceHistory(String pin, Double amount) {
        BalanceHistory balanceHistory = new BalanceHistory();
        balanceHistory.setPin(pin);
        balanceHistory.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        balanceHistory.setAmount(amount);
        return balanceHistoryRepository.save(balanceHistory);
    }

    public List<BalanceHistory> getBalanceHistoryByPin(String pin) {
        return balanceHistoryRepository.findByPin(pin);
    }
}