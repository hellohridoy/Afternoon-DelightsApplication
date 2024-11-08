package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.PinWithListOfBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinWithListOfBalanceRepository extends JpaRepository<PinWithListOfBalance,Long> {
    PinWithListOfBalance findByPin(String pin);
}
