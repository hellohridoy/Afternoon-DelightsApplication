package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.FoodOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberHistoryDto {
    private Long id;
    private String pin;
    private String name;
    private String email;
    private String officialPhoneNumber;
    private String departments;
    private Object balances; // Change to List<Balance> if multiple records are expected
    private Object foodOrder; // Change to List<DailyMeal> if multiple records are expected

    // Constructor
    public MemberHistoryDto(Long id, String pin, String name, String email,
                            String officialPhoneNumber, String departments,
                             Object balances, Object foodOrder) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.email = email;
        this.officialPhoneNumber = officialPhoneNumber;
        this.departments = departments;
        this.balances = balances;
        this.foodOrder = foodOrder;
    }
}
