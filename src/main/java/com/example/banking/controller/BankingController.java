package com.example.banking.controller;

import com.example.banking.dto.BankingResponse;
import com.example.banking.service.BankingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    // 1. GET /api/balance
    @GetMapping("/balance")
    public BankingResponse getBalance() {
        return bankingService.getBalance();
    }

    // 2. POST /api/deposit?amount=1000
    @PostMapping("/deposit")
    public BankingResponse deposit(@RequestParam double amount) {
        return bankingService.deposit(amount);
    }

    // 3. POST /api/withdraw?amount=500
    @PostMapping("/withdraw")
    public BankingResponse withdraw(@RequestParam double amount) {
        return bankingService.withdraw(amount);
    }

    // 4. POST /api/transfer?amount=200
    @PostMapping("/transfer")
    public BankingResponse transfer(@RequestParam double amount) {
        return bankingService.transfer(amount);
    }
}
