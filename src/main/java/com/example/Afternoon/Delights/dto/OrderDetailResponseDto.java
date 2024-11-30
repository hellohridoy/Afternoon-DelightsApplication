package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.mapper.PinDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderDetailResponseDto {
    private Long orderId;
    private List<PinDto> pins;
    private double totalCost;

    public OrderDetailResponseDto(Long orderId, List<PinDto> pins, double totalCost) {
        this.orderId = orderId;
        this.pins = pins;
        this.totalCost = totalCost;
    }


}

