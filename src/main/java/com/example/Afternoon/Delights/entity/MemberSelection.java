package com.example.Afternoon.Delights.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MemberSelection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pin;
    private String date;
    private boolean selected;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    // getters and setters
}
