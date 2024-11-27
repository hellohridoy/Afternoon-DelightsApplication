package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.FoodOrder;
import com.example.Afternoon.Delights.service.BalanceService;
import com.example.Afternoon.Delights.service.BalanceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequiredArgsConstructor
public class BalancedRestController {

    private final BalanceService balanceService;
    private final BalanceServiceImpl balanceServiceImpl;

    // Create or update balance
    @PostMapping("/afternoon-delights/balance/all-members")
    public ResponseEntity<Balance> addBalance(@Valid @RequestBody Balance balance) {
        Balance savedBalance = balanceService.saveBalance(balance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBalance);
    }

    // Get balance by ID
    @GetMapping("/afternoon-delights/balance/all-members/{id}")
    public ResponseEntity<Balance> getBalanceById(@PathVariable Long id) {
        Optional<Balance> balance = balanceService.getBalanceById(id);
        return balance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all balances
    @GetMapping("/afternoon-delights/balance/all-members")
    public ResponseEntity<List<Balance>> getAllBalances() {
        List<Balance> balances = balanceService.getAllBalances();
        return ResponseEntity.ok(balances);
    }

    // Delete balance by ID
    @DeleteMapping("/afternoon-delights/balance/all-members/{id}")
    public ResponseEntity<Void> deleteBalance(@PathVariable Long id) {
        Optional<Balance> balance = balanceService.getBalanceById(id);
        if (balance.isPresent()) {
            balanceService.deleteBalance(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/afternoon-delights/balance/all-members/subtract")
    public ResponseEntity<Map<String, Object>> subtractBalance(@RequestBody FoodOrder foodOrder) {

        // Extract pins and total cost from the FoodOrder object
        List<String> pins = foodOrder.getPins();
        Double totalCost = foodOrder.getTotalCost();

        // Subtract balance for each pin
        balanceServiceImpl.subtractBalance(pins, totalCost / pins.size());

        // Prepare the response message
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Balance updated for the following pins: " + pins.toString());
        response.put("amountDeductedPerPin", totalCost / pins.size());
        response.put("affectedPins", pins);

        // Return the response
        return ResponseEntity.ok(response);
    }
}
