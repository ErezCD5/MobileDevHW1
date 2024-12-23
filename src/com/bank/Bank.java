package com.bank;

import com.bank.interfaces.IBank;
import com.bank.interfaces.IAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;

    // Constructor
    public Bank() {
        this.accounts = new ArrayList<>(); // Initialize the account list
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account); // Add the account to the list
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToRemove = null;
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() < 0) {
                    System.out.println("Account " + accountNumber + " cannot be closed due to debt.");
                } else {
                    accountToRemove = account;
                }
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts); // Return a copy of the account list
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> filteredAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }
}
