package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.service.BalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RestController
@RequestMapping("/balance-history")
public class BalanceHistoryController {

    @Autowired
    private BalanceHistoryService balanceHistoryService;

    @GetMapping("/all")
    public List<BalanceHistory> memberAllBalanceHistory() {
        return balanceHistoryService.getAllBalance();
    }

    @PostMapping("/add-balance")
    public ResponseEntity<BalanceHistory> addBalance(@RequestBody BalanceHistory balanceHistory) {
        BalanceHistory savedBalanceHistory = balanceHistoryService.saveBalanceHistory(balanceHistory.getPin(), balanceHistory.getAmount());
        return ResponseEntity.ok(savedBalanceHistory);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Optional<BalanceHistory>> getBalanceHistory(@PathVariable Long id) {
        Optional<BalanceHistory> balanceHistories = balanceHistoryService.getBalanceHistoryByPin(id);
        return ResponseEntity.ok(balanceHistories);
    }
    @GetMapping("/member-per-month-balance-history/{pin}")
    public List<Double> getAccountsHistoryByPin(@RequestParam Long pin) {
        return balanceHistoryService.getAmountsByPin(pin);
    }
}
