package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBookDto {
    public Long id;
    private String profilePicture;
    private String pin;
    private String name;
    private String designation;
    private String unit;
    private String email;
    private String officialPhoneNumber;
}
