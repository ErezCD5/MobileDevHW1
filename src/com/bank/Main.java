package com.bank;

import com.bank.accounts.StandardAccount;
import com.bank.accounts.BasicAccount;
import com.bank.accounts.PremiumAccount;

public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();

        // Create accounts
        StandardAccount standardAccount = new StandardAccount(1, -100); // Credit limit = -100
        BasicAccount basicAccount = new BasicAccount(2, 100); // Withdrawal limit = 100
        PremiumAccount premiumAccount = new PremiumAccount(3);

        // Add accounts to the bank
        bank.OpenAccount(standardAccount);
        bank.OpenAccount(basicAccount);
        bank.OpenAccount(premiumAccount);

        // Deposit into all accounts
        System.out.println("Depositing 1000 into each account...");
        standardAccount.Deposit(1000);
        basicAccount.Deposit(1000);
        premiumAccount.Deposit(1000);

        // Withdraw from all accounts
        System.out.println("\nWithdrawing 3000 from each account...");
        System.out.println("Withdrawn " + standardAccount.Withdraw(3000) + " from Standard Account");
        System.out.println("Withdrawn " + basicAccount.Withdraw(3000) + " from Basic Account");
        System.out.println("Withdrawn " + premiumAccount.Withdraw(3000) + " from Premium Account");

        // List accounts in debt
        System.out.println("\nAccounts in debt:");
        for (var account : bank.GetAllAccountsInDebt()) {
            System.out.println("Account " + account.GetAccountNumber() + " is in debt.");
        }

        // Close accounts
        System.out.println("\nClosing all accounts...");
        bank.CloseAccount(1);
        bank.CloseAccount(2);
        bank.CloseAccount(3);

        // List remaining accounts
        System.out.println("Remaining accounts in the bank: " + bank.GetAllAccounts().size());
    }
}
