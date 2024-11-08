package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.PinWithListOfBalance;
import com.example.Afternoon.Delights.repository.PinWithListOfBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.NotActiveException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PinWithListOfBalanceService {
    private final PinWithListOfBalanceRepository pinWithListOfBalanceRepository;

    // Create or update
    public PinWithListOfBalance save(PinWithListOfBalance pinWithListOfBalance) {
        return pinWithListOfBalanceRepository.save(pinWithListOfBalance);
    }

    // Read
    public List<PinWithListOfBalance> getAll() {
        return pinWithListOfBalanceRepository.findAll();
    }

    public Optional<PinWithListOfBalance> getById(Long id) {
        return pinWithListOfBalanceRepository.findById(id);
    }

    public PinWithListOfBalance getByPin(String pin) {
        return pinWithListOfBalanceRepository.findByPin(pin);
    }

    // Delete
    public void deleteById(Long id) {
        pinWithListOfBalanceRepository.deleteById(id);
    }

    public PinWithListOfBalance saveOrUpdate(PinWithListOfBalance pinWithListOfBalance) {
        return pinWithListOfBalanceRepository.save(pinWithListOfBalance);
    }


    public Optional<PinWithListOfBalance> findByPin(String pin) {
        return Optional.ofNullable(pinWithListOfBalanceRepository.findByPin(pin));
    }


    public void addBalanceToPin(String pin, Double balanceAmount) {
        Optional<PinWithListOfBalance> optionalPinWithListOfBalance = Optional.ofNullable(pinWithListOfBalanceRepository.findByPin(pin));

        if (optionalPinWithListOfBalance.isPresent()) {
            PinWithListOfBalance pinWithListOfBalance = optionalPinWithListOfBalance.get();
            pinWithListOfBalance.getBalanceAmounts().add(balanceAmount);
            pinWithListOfBalanceRepository.save(pinWithListOfBalance);
        } else {
            // Handle case where pin doesn't exist, or create a new entry
            PinWithListOfBalance newPinWithListOfBalance = new PinWithListOfBalance();
            newPinWithListOfBalance.setPin(pin);
            newPinWithListOfBalance.setBalanceAmounts(List.of(balanceAmount));
            pinWithListOfBalanceRepository.save(newPinWithListOfBalance);
        }
    }
}
