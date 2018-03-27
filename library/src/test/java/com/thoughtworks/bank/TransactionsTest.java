package com.thoughtworks.bank;

import org.junit.Test;

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
}
