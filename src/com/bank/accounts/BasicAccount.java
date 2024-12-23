package com.bank.accounts;

import com.bank.interfaces.IAccount;

public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    // Constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = Math.max(0, withdrawalLimit); // Ensure withdrawal limit is positive
        this.balance = 0; // Initial balance is 0
    }

    @Override
    public void Deposit(double amount) {
        balance += amount; // Add the deposit amount to the balance
    }

    @Override
    public double Withdraw(double amount) {
        // Calculate the maximum allowable withdrawal
        double allowedWithdrawal = Math.min(balance, Math.min(amount, withdrawalLimit));
        balance -= allowedWithdrawal; // Deduct the allowed amount from the balance
        return allowedWithdrawal; // Return the actual withdrawn amount
    }

    @Override
    public double GetCurrentBalance() {
        return balance; // Return the current balance
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber; // Return the account number
    }
}
