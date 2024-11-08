package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.entity.JSONB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JSONBRepository extends JpaRepository<JSONB, Long> {
}
