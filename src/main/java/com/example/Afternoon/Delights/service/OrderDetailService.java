package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.OrderDetailResponseDto;
import com.example.Afternoon.Delights.entity.OrderDetail;
import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.mapper.OrderDetailMapper;
import com.example.Afternoon.Delights.repository.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailsRepository orderDetailRepository;

    public OrderDetailResponseDto saveOrder(OrderDetail orderDetail) {
        OrderDetail savedOrder = orderDetailRepository.save(orderDetail);
        return OrderDetailMapper.toDto(savedOrder);
    }

    public void addPin(Long orderId, Pin pin) {
        Optional<OrderDetail> orderDetailOpt = orderDetailRepository.findById(orderId);
        orderDetailOpt.ifPresent(orderDetail -> {
            orderDetail.getPins().add(pin);
            orderDetailRepository.save(orderDetail);
        });
    }
}

