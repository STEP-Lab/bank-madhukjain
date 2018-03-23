package com.thoughtworks.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
    protected CreditTransaction(double amount, Date date, String name) {
        super(amount,date,name);
    }
    public CreditTransaction(double amount, String name) {
        this(amount,new Date(),name);
    }
}
