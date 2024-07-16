package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.MealHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealHistoryRepository extends JpaRepository<MealHistory, Long> {
    List<MealHistory> findByMemberIdOrderByMealDateDesc(Long memberId);
}
