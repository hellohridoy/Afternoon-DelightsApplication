package com.example.Afternoon.Delights.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class PinWithListOfBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pin;  // PIN is used as the key, like the "room number" in your previous example

    @ElementCollection
    @CollectionTable(name = "balance_amounts", joinColumns = @JoinColumn(name = "balance_id"))
    @Column(name = "balance_amount")
    private List<Double> balanceAmounts;  // List of balance amounts, representing the values

    @CreationTimestamp
    private LocalDate createdAt;
}
