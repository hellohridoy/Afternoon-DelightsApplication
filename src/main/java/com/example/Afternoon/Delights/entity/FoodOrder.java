package com.example.Afternoon.Delights.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @Column(name = "order_pin") // Maps to the database column
    private String orderPin;

    private Double totalCost;

    private String foodItem;

    @ElementCollection
    private List<String> pins;

    @ElementCollection
    private Map<String, Double> amountPerMember; // To store per-member cost breakdown

}
