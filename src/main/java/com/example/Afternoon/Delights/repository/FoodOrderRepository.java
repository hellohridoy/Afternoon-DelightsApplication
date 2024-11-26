package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    @Query("SELECT f FROM FoodOrder f WHERE f.date = :date")
    List<FoodOrder> findByDate(String date);

    @Query("SELECT f FROM FoodOrder f")
    List<FoodOrder> findAllOrders();

    @Modifying
    @Transactional
    @Query("INSERT INTO FoodOrder (date, totalCost, foodItem, pins, amountPerMember) " +
            "VALUES (:date, :totalCost, :foodItem, :pins, :amountPerMember)")
    void postFoodOrder(@Param("date") String date,
                       @Param("totalCost") Double totalCost,
                       @Param("foodItem") String foodItem,
                       @Param("pins") List<String> pins,
                       @Param("amountPerMember") Double amountPerMember);

    @Transactional
    @Modifying
    @Query("UPDATE FoodOrder f SET f.totalCost = :totalCost, f.pins = :pins WHERE f.id = :id")
    Long updateFoodOrder(Long id, Double totalCost, List<String> pins);


    FoodOrder findByOrderPin(String orderPin); // Matches `orderPin` field



}

