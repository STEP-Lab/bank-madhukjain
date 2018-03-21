package com.thoughtworks.bank;

public class Account {
    private final String accountNumber;
    private double balance;
    private String name ;

    public Account(String name, String accNumber, double balance) throws InvalidAccountNumberError {
        checkAccountNumber(accNumber);
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

    private void checkAccountNumber(String givenAccountNumber) throws InvalidAccountNumberError {
        if(!givenAccountNumber.matches("[0-9]{4}-[0-9]{4}")){
            throw new InvalidAccountNumberError();
        }
    }

    public String getSummary() {
        return "Name: "+ name +"\nAccount Number: "+accountNumber+"\nBalance: "+balance;
    }
}
