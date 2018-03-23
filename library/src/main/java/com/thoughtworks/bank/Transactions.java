package com.thoughtworks.bank;

import java.util.ArrayList;

public class Transactions {
    private final ArrayList<Transaction> allTransactions;

    public Transactions() {
        this.allTransactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void credit(double amount, String name) {
        allTransactions.add(new CreditTransaction(amount,name));
    }
}
    