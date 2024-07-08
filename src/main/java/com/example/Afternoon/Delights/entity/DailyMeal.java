package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class DailyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private Double price;
    private Double perHeadAmount;

    @ElementCollection
    @CollectionTable(name = "participant_pins", joinColumns = @JoinColumn(name = "balance_id"))
    @Column(name = "pin")
    private List<String> participants;

    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}
