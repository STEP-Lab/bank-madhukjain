package com.thoughtworks.bank;

public class InvalidAmountError extends Throwable {
    public InvalidAmountError() {
        super("Entered amount is invalid");
    }
}
