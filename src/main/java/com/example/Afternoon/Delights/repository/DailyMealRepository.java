package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {

}
