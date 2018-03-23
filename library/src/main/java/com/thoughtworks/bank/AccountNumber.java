package com.thoughtworks.bank;

public class AccountNumber {
    private final String accountNumber;

    public AccountNumber(String accountNumber) throws InvalidAccountNumberError {
        checkAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
    }
    private void checkAccountNumber(String accountNumber) throws InvalidAccountNumberError {
        if(!accountNumber.matches("[0-9]{4}-[0-9]{4}")){
            throw new InvalidAccountNumberError();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}