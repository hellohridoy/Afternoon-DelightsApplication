package com.example.Afternoon.Delights.dto;

import lombok.Data;

@Data
public class CreateMemberRequest {
    private String pin;
    private String name;
    private String email;
    private String officialPhoneNumber;
    private String designation;
    private String departments;
    private String unit;
    private byte[] profilePicture;
    private Double addInitialValance;
}
