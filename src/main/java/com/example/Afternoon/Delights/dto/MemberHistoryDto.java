package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.DailyMeal;
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
    private String department;
    private String profilePicture;
    private List<BalanceDto> balances = new ArrayList<>();
    private List<DailyMealDto> dailyMeals = new ArrayList<>();

    public MemberHistoryDto(Long id, String pin, String name, String email, String officialPhoneNumber, String department, byte[] profilePicture, List<Balance> balances, List<DailyMeal> dailyMeals) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.email = email;
        this.officialPhoneNumber = officialPhoneNumber;
        this.department = department;
        this.profilePicture = (profilePicture != null) ? Base64.getEncoder().encodeToString(profilePicture) : null;
        this.balances = (balances != null) ? balances.stream().map(BalanceDto::from).toList() : new ArrayList<>();
        this.dailyMeals = (dailyMeals != null) ? dailyMeals.stream().map(DailyMealDto::from).toList() : new ArrayList<>();
    }

    @Getter
    @Setter
    public static class BalanceDto {
        private LocalDate date;
        private Double amount;

        public static BalanceDto from(Balance balance) {
            BalanceDto dto = new BalanceDto();
            dto.setDate(balance.getCreatedAt());
            dto.setAmount(balance.getBalanceAmount());
            return dto;
        }
    }

    @Getter
    @Setter
    public static class DailyMealDto {
        private LocalDate date;
        private String item;
        private Double cost;
        private Boolean isEating;

        public static DailyMealDto from(DailyMeal dailyMeal) {
            DailyMealDto dto = new DailyMealDto();
            dto.setDate(dailyMeal.getCreatedAt());
            dto.setItem(dailyMeal.getItem());
            dto.setCost(dailyMeal.getPrice());
            return dto;
        }
    }
}
