package com.thoughtworks.bank;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accNumber, double balance) throws InvalidAccountNumberError {
        checkAccountNumber(accNumber);
        this.accountNumber = accNumber;
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

    public static void checkAccountNumber(String givenAccountNumber) throws InvalidAccountNumberError {
        if(!givenAccountNumber.matches("[0-9]{4}-[0-9]{4}")){
            throw new InvalidAccountNumberError();
        }
    }
}
