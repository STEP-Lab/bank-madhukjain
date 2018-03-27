package com.thoughtworks.bank;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    private final ArrayList<Transaction> allTransactions;

    public Transactions() {
        this.allTransactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    protected void credit(Date date, double amount, String name) {
        allTransactions.add(new CreditTransaction(amount,date,name));
    }

    protected void debit(Date date, double amount, String name) {
        allTransactions.add(new DebitTransaction(amount,date,name));
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

    public Transactions getTransactionsWithAmountMoreThan(Balance balance){
        double amount = balance.getAmount();
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(amount < transaction.getAmount()){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getTransactionsWithAmountLessThan(Balance balance) {
        double amount = balance.getAmount();
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(amount > transaction.getAmount()){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }


    public Transactions getTransactionsDoneOnGivenDate(Date date) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(transaction.getDate().equals(date)){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getTransactionsDoneBeforeGivenDate(Date date) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(transaction.getDate().before(date)){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getTransactionsDoneAfterGivenDate(Date date) {
        Transactions transactions = new Transactions();
        for(Transaction transaction : allTransactions){
            if(transaction.getDate().after(date)){
                transactions.allTransactions.add(transaction);
            }
        }
        return transactions;
    }
}
    