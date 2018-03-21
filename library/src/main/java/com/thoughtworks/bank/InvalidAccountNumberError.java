package com.thoughtworks.bank;

public class InvalidAccountNumberError extends Throwable {
    public InvalidAccountNumberError(){
        super("Entered account number is invalid. Account number must contain 'four digit-four digit'.");
    }
}
