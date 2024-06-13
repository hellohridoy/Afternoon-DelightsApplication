package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {

}
