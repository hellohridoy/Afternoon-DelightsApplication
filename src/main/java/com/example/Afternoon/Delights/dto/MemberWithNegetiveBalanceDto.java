package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberWithNegetiveBalanceDto {
    private Long id;
    private String pin;
    private String name;
    private String officialPhoneNumber;
    private String departments;
    private String designation;
    private String email;
    private String profilePicture;
    private Double addInitialBalance;
}
