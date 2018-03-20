package com.thoughtworks.bank;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) throws InvalidAmountError {
        if(amount<0) throw new InvalidAmountError();
        balance += amount;
    }

    public void debit(double amount) throws InvalidAmountError, MinimumBalanceError {
        if((balance-amount)<=1000) throw new MinimumBalanceError();
        if(amount < 0) throw new InvalidAmountError();
        balance -= amount;
    }
}
