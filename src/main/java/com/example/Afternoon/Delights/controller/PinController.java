package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.service.PinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PinController {


    private final PinService pinService;

    @PostMapping("/afternoon-delights/member-details/pin")
    public ResponseEntity<Pin> savePin(@RequestBody Pin pin) {
        Pin savedPin = pinService.savePin(pin);
        return new ResponseEntity<>(savedPin, HttpStatus.CREATED);
    }

    @GetMapping("/afternoon-delights/member-details/pin")
    public ResponseEntity<List<Pin>> getAllPins() {
        List<Pin> pins = pinService.getAllPins();
        return new ResponseEntity<>(pins, HttpStatus.OK);
    }

    @GetMapping("/afternoon-delights/member-details/{pin}")
    public ResponseEntity<Pin> getPinById(@PathVariable String pin) {
        Pin pinData = pinService.getPinById(pin);
        return pinData != null ? new ResponseEntity<>(pinData, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
