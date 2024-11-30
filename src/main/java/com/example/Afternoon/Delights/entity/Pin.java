package com.example.Afternoon.Delights.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Pin {
    private String pin;
    @Id
    private Long id;

}
