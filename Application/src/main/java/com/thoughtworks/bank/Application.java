package com.thoughtworks.bank;

public class Application{
    public static void main(String[] args){
        Account account = new Account("1234",100.00);
        System.out.println(account.getBalance());
    }
}