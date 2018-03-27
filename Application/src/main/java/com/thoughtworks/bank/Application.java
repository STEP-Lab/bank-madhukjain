package com.thoughtworks.bank;


import static com.thoughtworks.bank.Balance.getBalance;

public class Application{
    public static void main(String[] args) throws InvalidAmountError, MinimumBalanceError, InvalidAccountNumberError, InvalidAmountException {
        Balance balance = getBalance(1000.00);
        Account account = new Account("Madhuri",new AccountNumber("1234-1234"),balance);
        System.out.println(account.getBalance());
        account.credit(10000.0,"Madhuri");
        System.out.println(account.getBalance());
        account.debit(5000.0,"Madhuri");
        System.out.println(account.getBalance());
        System.out.println(account.getSummary());
    }
}