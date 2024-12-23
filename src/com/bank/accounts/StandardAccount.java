package com.bank.accounts;

import com.bank.interfaces.IAccount;

public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit < 0 ? creditLimit : 0; // Ensure negative credit limit
        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (balance - amount >= creditLimit) {
            balance -= amount;
            return amount;
        } else {
            double allowedWithdrawal = balance - creditLimit;
            balance = creditLimit; // Set balance to the credit limit
            return allowedWithdrawal;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
