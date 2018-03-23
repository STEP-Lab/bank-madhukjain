package com.thoughtworks.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

    @Test
    public void shouldReturnAmountFromDebitTransaction() {
        Date date = new Date();
        Transaction debitTransaction = new DebitTransaction(1000.00, date, "Madhuri");
        assertThat(debitTransaction.getAmount(),is(1000.00));
    }

    @Test
    public void shouldReturnAmountFromCreditTransaction() {
        Date date = new Date();
        Transaction creditTransaction = new CreditTransaction(2000.00, date, "Mayuri");
        assertThat(creditTransaction.getAmount(),is(2000.00));
    }
}
