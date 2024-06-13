package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afternoon-delights/balance")

public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/all")
    public List<Balance> all() {
        return balanceService.getAllBalance();
    }

    @GetMapping("/{id}")
    public Balance findById(@PathVariable Long id) {
        return balanceService.getBalanceById(id);
    }

    @PostMapping("/add-members")
    public Balance addBalance(@RequestBody Balance balance) {
        return balanceService.addBalance(balance);
    }

    @PutMapping("/{id}")
    public Balance updateBalance(@PathVariable Long id, @RequestBody Balance balance) {
        return balanceService.updateBalance(id, balance);
    }

    @DeleteMapping("/delete/{id}")
    public void  deleteBalance(@PathVariable Long id) {
        balanceService.deleteBalance(id);
    }
}
