package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.service.BalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RestController
@RequestMapping("/balance-history")
public class BalanceHistoryController {

    @Autowired
    private BalanceHistoryService balanceHistoryService;

    @PostMapping
    public ResponseEntity<BalanceHistory> addBalance(@RequestBody BalanceHistory balanceHistory) {
        BalanceHistory savedBalanceHistory = balanceHistoryService.saveBalanceHistory(balanceHistory.getPin(), balanceHistory.getAmount());
        return ResponseEntity.ok(savedBalanceHistory);
    }

    @GetMapping("/{pin}")
    public ResponseEntity<List<BalanceHistory>> getBalanceHistory(@PathVariable String pin) {
        List<BalanceHistory> balanceHistories = balanceHistoryService.getBalanceHistoryByPin(pin);
        return ResponseEntity.ok(balanceHistories);
    }
}
