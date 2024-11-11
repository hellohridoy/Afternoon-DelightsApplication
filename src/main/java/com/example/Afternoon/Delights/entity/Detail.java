package com.example.Afternoon.Delights.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "meal_details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String foodItem;
    private Double totalCost;
    private Boolean isEat;  // Whether the employee ate on that day or not
    private Double todayCost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonBackReference// Add cascade option
    @JoinColumn(name = "pin_id", nullable = false) // Ensure foreign key column name is correct
    private Pin pin;
}
