package com.thoughtworks.bank;


public class Application{
    public static void main(String[] args) throws InvalidAmountError, MinimumBalanceError, InvalidAccountNumberError {
        Account account = new Account("Madhuri",new AccountNumber("1234-1234"),1000.00);
        System.out.println(account.getBalance());
        account.credit(10000.0,"Madhuri");
        System.out.println(account.getBalance());
        account.debit(5000.0,"Madhuri");
        System.out.println(account.getBalance());
        System.out.println(account.getSummary());
    }
}