package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.ENUM.BalanceType;
import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.repository.BalanceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;


    // Create or update a balance entry
    @Override
    public Balance saveBalance(Balance balance) {
        return balanceRepository.save(balance);  // Save method handles both create and update
    }

    // Retrieve a balance by its ID
    @Override
    public Optional<Balance> getBalanceById(Long id) {
        return balanceRepository.findById(id);
    }

    // Retrieve all balances
    @Override
    public List<Balance> getAllBalances() {
        return balanceRepository.findAll();
    }

    // Delete a balance by its ID
    @Override
    public void deleteBalance(Long id) {
        balanceRepository.deleteById(id);
    }

}


