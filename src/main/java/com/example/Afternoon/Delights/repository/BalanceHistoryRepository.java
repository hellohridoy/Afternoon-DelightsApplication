package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, Long> {
    @Query("SELECT b.amount FROM BalanceHistory b WHERE b.id = :id")
    List<Double> findAmountsById(Long id);
}
