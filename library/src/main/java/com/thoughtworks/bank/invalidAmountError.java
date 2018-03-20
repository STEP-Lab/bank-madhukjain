package com.thoughtworks.bank;

public class invalidAmountError extends Throwable {
    public invalidAmountError() {
        super("Entered amount is invalid");
    }
}
