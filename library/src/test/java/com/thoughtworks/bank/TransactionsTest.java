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
}
