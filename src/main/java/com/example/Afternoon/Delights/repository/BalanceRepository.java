package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    List<Balance> findByPinOrderByCreatedAtDesc(String pin);
    List<Balance> findAllByOrderByCreatedAtDesc();
    @Query("SELECT b FROM Balance b WHERE b.balance < 0")
    List<Balance> findMembersWithNegativeBalance();// Fetch all balances ordered by creation date
}

