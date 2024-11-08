package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.PinWithListOfBalance;
import com.example.Afternoon.Delights.repository.PinWithListOfBalanceRepository;
import com.example.Afternoon.Delights.service.BalanceService;
import com.example.Afternoon.Delights.service.PinWithListOfBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class BalanceWithPinMappingRestController {
    private final PinWithListOfBalanceService pinWithListOfBalanceService;
    private final PinWithListOfBalanceRepository repository;

    // Create or Update
    @PostMapping("/afternoon-delights/dashboard/balance-infos")
    public ResponseEntity<PinWithListOfBalance> createOrUpdatePin(@RequestBody PinWithListOfBalance pinWithListOfBalance) {
        PinWithListOfBalance saved = pinWithListOfBalanceService.save(pinWithListOfBalance);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get all
    @GetMapping("/afternoon-delights/dashboard/balance-infos")
    public ResponseEntity<List<PinWithListOfBalance>> getAllPins() {
        List<PinWithListOfBalance> pins = pinWithListOfBalanceService.getAll();
        return new ResponseEntity<>(pins, HttpStatus.OK);
    }

    // Get by id
    @GetMapping("/afternoon-delights/dashboard/balance-infos/{id}")
    public ResponseEntity<PinWithListOfBalance> getPinById(@PathVariable Long id) {
        Optional<PinWithListOfBalance> pin = pinWithListOfBalanceService.getById(id);
        return pin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get by pin
    @GetMapping("/afternoon-delights/dashboard/balance-infos/{pin}")
    public ResponseEntity<PinWithListOfBalance> getPinByPin(@PathVariable String pin) {
        PinWithListOfBalance pinData = pinWithListOfBalanceService.getByPin(pin);
        if (pinData != null) {
            return new ResponseEntity<>(pinData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/afternoon-delights/dashboard/balance-infos/{id}")
    public ResponseEntity<Void> deletePinById(@PathVariable Long id) {
        pinWithListOfBalanceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to add a balance to an existing pin
    @PatchMapping("/afternoon-delights/dashboard/balance-infos/{pin}/add-balance")
    public ResponseEntity<Void> addBalanceToPin(@PathVariable String pin, @RequestParam Double balanceAmount) {
        pinWithListOfBalanceService.addBalanceToPin(pin, balanceAmount);
        return ResponseEntity.ok().build();
    }
}
