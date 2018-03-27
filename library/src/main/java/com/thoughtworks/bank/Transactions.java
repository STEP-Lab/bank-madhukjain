package com.thoughtworks.bank;

import java.util.ArrayList;

public class Transactions {
    private final ArrayList<Transaction> allTransactions;
    private Transactions transactions;

    public Transactions() {
        this.allTransactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    public void credit(double amount, String name) {
        allTransactions.add(new CreditTransaction(amount,name));
    }

    public void debit(double amount, String name) {
        allTransactions.add(new DebitTransaction(amount,name));
    }

    public Transactions getAllCreditTransactions() {
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(transaction instanceof CreditTransaction){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getAllDebitTransactions() {
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(transaction instanceof DebitTransaction){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }

}
    