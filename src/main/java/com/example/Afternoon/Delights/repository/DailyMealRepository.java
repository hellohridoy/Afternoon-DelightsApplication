package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Long> {

    @Query(value = "SELECT COUNT(*) FROM daily_meal WHERE id = :id", nativeQuery = true)
    int countParticipantsByIdNative(@Param("id") Long id);

    @Query("SELECT SUM(e.price) FROM DailyMeal e")
    Double findTotalBalance();
}
