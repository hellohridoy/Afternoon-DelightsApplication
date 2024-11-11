package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.entity.Pin;

import java.util.List;

public interface PinDao {
    Pin savePin(Pin pin);
    List<Pin> getAllPins();
    Pin findByPin(String pin);  // Find employee by PIN
}
