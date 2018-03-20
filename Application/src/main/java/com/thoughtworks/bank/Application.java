package com.thoughtworks.bank;


public class Application{
    public static void main(String[] args) throws invalidAmountError, minimumBalanceError {
        Account account = new Account("1234-4344",1000.00);
        System.out.println(account.getBalance());
        account.credit(10000);
        System.out.println(account.getBalance());
        account.debit(5000);
        System.out.println(account.getBalance());
    }
}