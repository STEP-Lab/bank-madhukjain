package com.thoughtworks.bank;

public class MinimumBalanceError extends Throwable {
    public MinimumBalanceError(){
        super("Insufficient balance");
    }
}
