package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.entity.Pin;

import java.time.LocalDate;
import java.util.List;

public interface DetailsDao {

    Detail saveDetail(Detail detail);

    // Get meal details for a specific employee (by pin) within a date range
    List<Detail> findByPinAndDateRange(String pin, LocalDate startDate, LocalDate endDate);

    // Get total meal details for all employees within a date range
    List<Detail> findAllByDateRange(LocalDate startDate, LocalDate endDate);

    // Get total cost and number of meals for an employee within a specific month
    Double getTotalCostForEmployeeInMonth(String pin, LocalDate startDate, LocalDate endDate);

    Long getTotalMealCountForEmployeeInMonth(String pin, LocalDate startDate, LocalDate endDate);

}
