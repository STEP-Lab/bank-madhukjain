package com.thoughtworks.bank;

public class Account {
    private final AccountNumber accountNumber;
    private double balance;
    private String name ;

    public Account(String name, AccountNumber accNumber, double balance) throws InvalidAccountNumberError {
        this.accountNumber = accNumber;
        this.balance = balance;
        this.name = name;
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

    public String getSummary() {
        return "Name: "+ name +"\nAccount Number: "+accountNumber.getAccountNumber()+"\nBalance: "+balance;
    }
}
