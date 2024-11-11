package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.repository.PinRepository;
import com.example.Afternoon.Delights.service.PinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ControllerAdvice
public class PinController {


    private final PinService pinService;

    @PostMapping("/afternoon-delights/member-details/pin")
    public Pin savePin(@RequestBody Pin pin) {
        return pinService.savePin(pin);
    }

    @GetMapping("/afternoon-delights/member-details/pin")
    public List<Pin> getAllPins() {
        return pinService.getAllPins();
    }

    @GetMapping("/afternoon-delights/member-details/pin/{pin}")
    public Pin getPinByPin(@PathVariable String pin) {
        return pinService.getPinByPin(pin);
    }
}
