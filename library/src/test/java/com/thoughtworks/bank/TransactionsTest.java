package com.thoughtworks.bank;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.thoughtworks.bank.Balance.getBalance;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    @Test
    public void shouldStoreAllCreditTransactions() {
        Transactions transactions = new Transactions();
        transactions.credit(1000.00,"Madhuri");
        assertThat(transactions.getAllTransactions(),hasItem(new CreditTransaction(1000.00,"Madhuri")));
    }

    @Test
    public void shouldStoreAllDebitTransactions() {
        Transactions transactions = new Transactions();
        transactions.debit(1000.00,"Madhuri");
        assertThat(transactions.getAllTransactions(),hasItem(new DebitTransaction(1000.00,"Madhuri")));
    }

    @Test
    public void shouldStoreDebitAndCreditTransactions() {
        Transactions transactions = new Transactions();
        transactions.credit(1000.00,"Madhuri");
        transactions.debit(1000.00,"Madhuri");
        assertThat(transactions.getAllTransactions(),hasItem(new CreditTransaction(1000.00,"Madhuri")));
        assertThat(transactions.getAllTransactions(),hasItem(new DebitTransaction(1000.00,"Madhuri")));
    }

    @Test
    public void shouldReturnAllCreditTransactions() {
        Transactions transactions = new Transactions();
        transactions.credit(1000.00,"Madhuri");
        transactions.credit(1500.00,"Madhuri");
        transactions.debit(1000.00,"Madhuri");
        CreditTransaction creditTransaction = new CreditTransaction(1000.00, "Madhuri");
        Transactions creditTransactions = transactions.getAllCreditTransactions();
        assertThat(creditTransactions.getAllTransactions(),hasItem(creditTransaction));
    }

    @Test
    public void shouldReturnAllDebitTransactions() {
        Transactions transactions = new Transactions();
        transactions.credit(20000.00,"Mayuri");
        transactions.debit(1000.00,"Mayuri");
        transactions.debit(1500.00,"Mayuri");
        DebitTransaction debitTransaction = new DebitTransaction(1000.00, "Mayuri");
        Transactions debitTransactions = transactions.getAllDebitTransactions();
        assertThat(debitTransactions.getAllTransactions(),hasItem(debitTransaction));
    }

    @Test
    public void shouldReturnTransactionHavingAmountMoreThanGivenThreshold() throws InvalidAmountException {
        Transactions transactions = new Transactions();
        transactions.credit(1500.00,"Mayuri");
        transactions.debit(2000.00,"Mayuri");
        transactions.credit(2500.00,"Mayuri");
        transactions.debit(2300.00,"Mayuri");
        Balance balance = getBalance(1800);
        Transactions transactionsWithAmountMoreThan = transactions.getTransactionsWithAmountMoreThan(balance);
        DebitTransaction debitTransaction = new DebitTransaction(2000.00, "Mayuri");
        assertThat(transactionsWithAmountMoreThan.getAllTransactions(),hasItem(debitTransaction));
    }

    @Test(expected = InvalidAmountException.class)
    public void shouldThrowExceptionForRequestOfInvalidAmount() throws InvalidAmountException {
        Transactions transactions = new Transactions();
        transactions.credit(1500.00,"Mayuri");
        transactions.debit(2000.00,"Mayuri");
        transactions.credit(2500.00,"Mayuri");
        transactions.debit(2300.00,"Mayuri");
        getBalance(-1800);
    }

    @Test
    public void shouldReturnTransactionsHavingAmountLessThanGivenThreshold() throws InvalidAmountException {
        Transactions transactions = new Transactions();
        transactions.credit(1000.00,"Madhuri");
        transactions.debit(1500.00,"Madhuri");
        transactions.credit(1300.00,"Madhuri");
        Balance balance = getBalance(1500);
        Transactions transactionsWithAmountLessThan = transactions.getTransactionsWithAmountLessThan(balance);
        CreditTransaction creditTransaction = new CreditTransaction(1000.00, "Madhuri");
        assertThat(transactionsWithAmountLessThan.getAllTransactions(),hasItem(creditTransaction));
    }

    @Test
    public void shouldReturnTransactionsDoneOnGivenDate() throws ParseException {
        Transactions transactions = new Transactions();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse("30-12-2018");
        transactions.credit(date,1000.00,"Madhuri");
        transactions.debit(date,1500.00,"Madhuri");
        Transactions transactionsDoneOnGivenDate = transactions.getTransactionsDoneOnGivenDate(date);
        CreditTransaction creditTransaction = new CreditTransaction(1000.00, date, "Madhuri");
        assertThat(transactionsDoneOnGivenDate.getAllTransactions(),hasItem(creditTransaction));
    }

    @Test
    public void shouldReturnTransactionsDoneBeforeOfGivenDate() throws ParseException {
        Transactions transactions = new Transactions();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date prevDate = dateFormat.parse("30-12-2017");
        Date upcomingDate = dateFormat.parse("30-12-2017");
        transactions.credit(prevDate,1000.00,"Madhuri");
        transactions.debit(upcomingDate,1500.00,"Madhuri");
        Transactions transactionsDoneBeforeGivenDate = transactions.getTransactionsDoneBeforeGivenDate(date);
        CreditTransaction creditTransaction = new CreditTransaction(1000.00, prevDate, "Madhuri");
        assertThat(transactionsDoneBeforeGivenDate.getAllTransactions(),hasItem(creditTransaction));
    }
}
