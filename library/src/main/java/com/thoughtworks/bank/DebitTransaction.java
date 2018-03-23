package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

    protected DebitTransaction(double amount, Date date, String name) {
        super(amount,date,name);
    }
    public DebitTransaction(double amount,String name){
        this(amount,new Date(),name);
    }

}
