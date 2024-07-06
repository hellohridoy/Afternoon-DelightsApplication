package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.dto.BalanceDTO;
import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
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

    @PostMapping("/add-balance")
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

    @GetMapping("/total")
    public Double getTotalBalance() {
        return balanceService.getTotalBalance();
    }

    @GetMapping("/history/{pin}")
    public List<BalanceDTO> getBalanceHistory(@PathVariable String pin) {
        return balanceService.getBalanceHistory(pin);
    }

    @GetMapping("/history")
    public List<BalanceDTO> getAllMemberBalanceHistory() {
        return balanceService.getAllMemberBalanceHistory();
    }

    @GetMapping("/negative")
    public List<Balance> getMembersWithNegativeBalance() {
        return balanceService.getMembersWithNegativeBalance();
    }

}
