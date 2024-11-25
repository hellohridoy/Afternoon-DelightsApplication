package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class DailyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pin;

    private String item;

    private Double price;

    private Double perHeadAmount;

    @ElementCollection
    @CollectionTable(name = "participant_pins", joinColumns = @JoinColumn(name = "meal_id"))
    @Column(name = "pin")
    private List<String> participants;

    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
