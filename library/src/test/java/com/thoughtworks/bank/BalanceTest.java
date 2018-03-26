package com.thoughtworks.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BalanceTest {

    @Test
    public void shouldReturnGivenAmount() throws InvalidAmountException {
        Balance balance = new Balance(10000);
        assertThat(balance.getAmount(),is(10000.00));
    }

    @Test(expected = InvalidAmountException.class)
    public void shouldThrowExceptionIfRequestedAmountIsInvalid() throws InvalidAmountException {
        Balance balance = new Balance(-10000);
    }
}
