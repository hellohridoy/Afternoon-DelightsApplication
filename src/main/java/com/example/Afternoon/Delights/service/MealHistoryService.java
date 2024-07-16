package com.example.Afternoon.Delights.service;


import com.example.Afternoon.Delights.entity.MealHistory;
import com.example.Afternoon.Delights.repository.MealHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealHistoryService {
    @Autowired
    private MealHistoryRepository mealHistoryRepository;

    public List<MealHistory> getMealHistoryForMember(Long memberId) {
        return mealHistoryRepository.findByMemberIdOrderByMealDateDesc(memberId);
    }
}
