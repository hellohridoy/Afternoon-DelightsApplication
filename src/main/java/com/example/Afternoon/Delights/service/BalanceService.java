package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Balance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BalanceService {

    public List<Balance> getAllBalance();

    public Balance getBalanceById(Long id);

    public Balance addBalance(Balance balance);

    public Balance updateBalance(Long id,Balance balance);

    public void deleteBalance(Long id);
}
