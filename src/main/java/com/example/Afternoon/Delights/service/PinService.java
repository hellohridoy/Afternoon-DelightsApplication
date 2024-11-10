package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Pin;

import java.util.List;

public interface PinService {
    Pin savePin(Pin pin);
    List<Pin> getAllPins();
    Pin getPinById(String pin);
}
