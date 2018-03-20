package com.thoughtworks.bank;

public class minimumBalanceError extends Throwable {
    public minimumBalanceError(){
        super("Insufficient balance");
    }
}
