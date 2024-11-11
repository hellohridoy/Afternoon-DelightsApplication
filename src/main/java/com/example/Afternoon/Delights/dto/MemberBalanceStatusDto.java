package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberBalanceStatusDto {
    private Long id;
    private String pin;
    private String name;
    private String officialPhoneNumber;
    private String designation;
    private String email;
    private Double addInitialBalance;

    public MemberBalanceStatusDto(Long id, String pin, String name, String officialPhoneNumber, String designation, String email, Double addInitialBalance) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.officialPhoneNumber = officialPhoneNumber;
        this.designation = designation;
        this.email = email;
        this.addInitialBalance = addInitialBalance;
    }

}
