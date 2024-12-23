package com.bank.accounts;

import com.bank.interfaces.IAccount;

public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    // Constructor
    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Initial balance is 0
    }

    @Override
    public void Deposit(double amount) {
        balance += amount; // Add the deposit amount to the balance
    }

    @Override
    public double Withdraw(double amount) {
        balance -= amount; // Deduct the requested amount, balance can go negative
        return amount; // Return the full amount withdrawn
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
