package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.ENUM.BalanceType;
import com.example.Afternoon.Delights.entity.Balance;

import java.util.List;
import java.util.Optional;

public interface BalanceService {

    // Create or update a balance entry
    Balance saveBalance(Balance balance);

    // Retrieve a balance by its ID
    Optional<Balance> getBalanceById(Long id);

    // Retrieve all balances
    List<Balance> getAllBalances();

    // Delete a balance by its ID
    void deleteBalance(Long id);}
