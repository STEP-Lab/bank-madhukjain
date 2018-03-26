package com.thoughtworks.bank;

public class InvalidAmountException extends Throwable {
    public InvalidAmountException(){
        super("Requested amount for balance is invalid. Entered amount should not be negative.");
    }
}
