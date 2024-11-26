package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Balance findByPin(String pin); // Correct field name    Optional<Balance> findByPinAndMemberId(String pin, Long memberId);
    void deleteByPinAndMemberId(String pin, Long memberId); // Method to delete balance entry


}

