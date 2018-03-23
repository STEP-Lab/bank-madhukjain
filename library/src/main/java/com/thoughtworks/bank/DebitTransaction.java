package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

    public DebitTransaction(double amount, Date date, String name) {
        super(amount,date,name);
    }

}
