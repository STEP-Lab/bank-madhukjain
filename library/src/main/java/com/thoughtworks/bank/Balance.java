package com.thoughtworks.bank;

public class Balance {
    private final double amount;

    private Balance(double amount){
        this.amount = amount;
    }

    public static Balance getBalance(double value) throws InvalidAmountException {
        if(value<0) throw new InvalidAmountException();
        return new Balance(value);
    }

    public double getAmount() {
        return amount;
    }
}
