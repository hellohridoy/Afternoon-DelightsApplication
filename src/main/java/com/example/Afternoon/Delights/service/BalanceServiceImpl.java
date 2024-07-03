package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    public List<Balance> getAllBalance(){
        return balanceRepository.findAll();
    }

    public Balance getBalanceById(Long id){
        return balanceRepository.findById(id).orElse(null);
    }

    public Balance addBalance(Balance balance){

        return balanceRepository.save(balance);
    }

    public Balance updateBalance(Long id,Balance balance){
        if (balanceRepository.existsById(id)){
            balance.setId(id);
            return balanceRepository.save(balance);
        }
        return null;
    }

    public void deleteBalance(Long id){
        balanceRepository.deleteById(id);
    }

    public Double getTotalBalance() {
        return balanceRepository.findAll().stream()
                .mapToDouble(Balance::getBalance)  // Assuming `price` is a field in the `Balance` entity
                .sum();
    }
}
