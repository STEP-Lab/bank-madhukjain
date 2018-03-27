package com.thoughtworks.bank;

import org.junit.Test;

import static com.thoughtworks.bank.Balance.getBalance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BalanceTest {

    @Test
    public void shouldReturnGivenAmount() throws InvalidAmountException {
        Balance balance = getBalance(10000);
        assertThat(balance.getAmount(),is(10000.00));
    }

    @Test(expected = InvalidAmountException.class)
    public void shouldThrowExceptionIfRequestedAmountIsInvalid() throws InvalidAmountException {
        getBalance(-10000);
    }
}
