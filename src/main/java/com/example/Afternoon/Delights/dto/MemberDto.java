package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private double amount;

    public MemberDto(long id, String name, double addInitialBalance) {
        this.id = id;
        this.name = name;
        this.amount = addInitialBalance;
    }
}
