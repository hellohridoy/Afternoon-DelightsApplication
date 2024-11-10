package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.repository.PinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PinServiceImpl implements PinService {

    private final PinRepository pinRepository;

    @Override
    public Pin savePin(Pin pin) {
        return pinRepository.save(pin);
    }

    @Override
    public List<Pin> getAllPins() {
        return pinRepository.findAll();
    }

    @Override
    public Pin getPinById(String pin) {
        Optional<Pin> optionalPin = pinRepository.findById(pin);
        return optionalPin.orElse(null);
    }
}

