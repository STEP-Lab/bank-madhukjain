package com.thoughtworks.bank;


public class Application{
    public static void main(String[] args){
        Account account = new Account("1234-4344",100.00);
        System.out.println(account.getBalance());
        account.credit(10000);
        System.out.println(account.getBalance());
    }
}