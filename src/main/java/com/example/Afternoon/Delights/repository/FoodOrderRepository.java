package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    @Query("SELECT f FROM FoodOrder f WHERE f.date = :date")
    List<FoodOrder> findByDate(String date);

    @Query("SELECT f FROM FoodOrder f")
    List<FoodOrder> findAllOrders();

}

