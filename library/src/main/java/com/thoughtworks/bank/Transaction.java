package com.thoughtworks.bank;

import java.util.Date;

public class Transaction {
    private final Date date;
    protected final String name;
    protected double amount;

    public Transaction(double amount, Date date, String name) {
        this.amount = amount;
        this.date = date;
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
