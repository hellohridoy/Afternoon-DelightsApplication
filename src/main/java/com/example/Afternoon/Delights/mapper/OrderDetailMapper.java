package com.example.Afternoon.Delights.mapper;

import com.example.Afternoon.Delights.dto.OrderDetailResponseDto;
import com.example.Afternoon.Delights.entity.OrderDetail;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailMapper {
    public static OrderDetailResponseDto toDto(OrderDetail orderDetail) {
        // Map pins to PinDto
        List<PinDto> pinDtos = orderDetail.getPins() != null
                ? orderDetail.getPins().stream()
                .map(pin -> {
                    PinDto pinDto = new PinDto();
                    pinDto.setPin(pin.getPin()); // Assuming `getPin()` in Pin returns a String
                    return pinDto;
                })
                .collect(Collectors.toList())
                : Collections.emptyList();

        // Create and return the DTO
        return new OrderDetailResponseDto(
                orderDetail.getId(),
                pinDtos,
                orderDetail.getTotalCost()
        );
    }
}


