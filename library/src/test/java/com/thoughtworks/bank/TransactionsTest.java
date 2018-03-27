package com.thoughtworks.bank;

import org.junit.Test;

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
    public void shouldReturnAllTransactionHavingAmountMoreThanGivenAmount() throws InvalidAmountException {
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

}
