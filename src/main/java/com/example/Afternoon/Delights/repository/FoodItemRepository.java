package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.FoodItem;
import com.example.Afternoon.Delights.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> , PagingAndSortingRepository<FoodItem,Long>
{
}
