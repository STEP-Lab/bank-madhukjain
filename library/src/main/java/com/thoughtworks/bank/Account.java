package com.thoughtworks.bank;

import java.util.ArrayList;

public class Account {
    private final AccountNumber accountNumber;
    private final Transactions allTransactions;
    private double balance;
    private String name ;

    public Account(String name, AccountNumber accNumber, Balance balance) {
        this.accountNumber = accNumber;
        this.balance = balance.getAmount();
        this.name = name;
        this.allTransactions = new Transactions();
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount,String creditedTo) throws InvalidAmountError {
        if(amount<0) throw new InvalidAmountError();
        balance += amount;
        allTransactions.credit(amount,creditedTo);
    }

    public void debit(double amount,String debitedFrom) throws InvalidAmountError, MinimumBalanceError {
        if((balance-amount)<=1000) throw new MinimumBalanceError();
        if(amount < 0) throw new InvalidAmountError();
        balance -= amount;
        allTransactions.debit(amount,debitedFrom);
    }

    public String getSummary() {
        return "Name: "+ name +"\nAccount Number: "+accountNumber.getAccountNumber()+"\nBalance: "+balance;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions.getAllTransactions();
    }
}
