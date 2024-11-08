package com.example.Afternoon.Delights.entity;

import com.example.Afternoon.Delights.ENUM.BalanceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Balance is required")
    @Min(value = 0, message = "Balance must be greater than or equal to 0")
    private Double balanceAmount;

    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;  // ADD or DEDUCT

    @NotBlank(message = "PIN is required")
    @Size(max = 4, message = "PIN must be at most 4 characters long")
    private String pin;

    private LocalDateTime createdAt;

    // Many-to-one relationship with Member
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


}
