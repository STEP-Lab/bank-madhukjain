package com.thoughtworks.bank;

public class Balance {
    private final double amount;

    public Balance(double amount) throws InvalidAmountException {
        checkInvalidAmount(amount);
        this.amount = amount;
    }

    private void checkInvalidAmount(double value) throws InvalidAmountException {
        if(value<0){
            throw new InvalidAmountException();
        }
    }

    public double getAmount() {
        return amount;
    }
}
