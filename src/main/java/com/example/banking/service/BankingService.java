package com.example.banking.service;

import com.example.banking.dto.BankingResponse;
import org.springframework.stereotype.Service;

@Service
public class BankingService {

    // Initial in-memory balance of ₹10,000
    private double balance = 10000.0;

    public synchronized BankingResponse getBalance() {
        return new BankingResponse(true, "Current balance fetched successfully.", balance);
    }

    public synchronized BankingResponse deposit(double amount) {
        if (amount <= 0) {
            return new BankingResponse(false, "Deposit failed: Amount must be greater than zero.", balance);
        }
        balance += amount;
        return new BankingResponse(true, "Deposit of ₹" + amount + " successful.", balance);
    }

    public synchronized BankingResponse withdraw(double amount) {
        if (amount <= 0) {
            return new BankingResponse(false, "Withdrawal failed: Amount must be greater than zero.", balance);
        }
        if (amount > balance) {
            return new BankingResponse(false, "Withdrawal failed: Insufficient balance. Available: ₹" + balance, balance);
        }
        balance -= amount;
        return new BankingResponse(true, "Withdrawal of ₹" + amount + " successful.", balance);
    }

    public synchronized BankingResponse transfer(double amount) {
        if (amount <= 0) {
            return new BankingResponse(false, "Transfer failed: Amount must be greater than zero.", balance);
        }
        if (amount > balance) {
            return new BankingResponse(false, "Transfer failed: Insufficient balance. Available: ₹" + balance, balance);
        }
        balance -= amount;
        return new BankingResponse(true, "Transfer of ₹" + amount + " simulated and completed successfully.", balance);
    }
}
