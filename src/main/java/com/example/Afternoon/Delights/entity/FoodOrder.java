package com.example.Afternoon.Delights.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
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

    @Column(name = "order_pin")
    private String orderPin;

    private Double totalCost;

    private String foodItem;

    @ElementCollection
    private List<String> pins;

    @ElementCollection
    private Map<String, Double> amountPerMember = new HashMap<>();

    /**
     * Calculates and sets amountPerMember based on totalCost and pins.
     */
    @PrePersist
    @PreUpdate
    public void calculateAmountPerMember() {
        if (pins != null && !pins.isEmpty() && totalCost != null) {
            double splitAmount = totalCost / pins.size();
            amountPerMember.clear(); // Clear any existing values
            for (String pin : pins) {
                amountPerMember.put(pin, splitAmount);
            }
        } else {
            amountPerMember.clear(); // If no pins or totalCost, clear the map
        }
    }
}
