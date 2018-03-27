package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.bank.Balance.getBalance;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws InvalidAccountNumberError, InvalidAmountException {
        Balance balance = getBalance(1000.00);
        account = new Account("Madhuri",new AccountNumber("1234-1234"),balance);
    }

    @Test
    public void shouldReturnAvailableBalance() {
        assertEquals(account.getBalance(),1000.00);
    }

    @Test
    public void shouldAddGivenAmountToAccount() throws InvalidAmountError {
        account.credit(10000.00,"Madhuri");
        assertEquals(account.getBalance(),11000.00);
    }

    @Test
    public void shouldWithdrawAmount() throws InvalidAmountError, MinimumBalanceError {
        account.credit(10000.00,"Madhuri");
        account.debit(5000.00,"Madhuri");
        assertEquals(account.getBalance(),6000,0);
    }

    @Test(expected = InvalidAmountError.class)
    public void shouldReturnInvalidAmountErrorForCredit() throws InvalidAmountError {
        account.credit(-10000.00,"Madhuri");
    }

    @Test(expected = InvalidAmountError.class)
    public void shouldReturnInvalidAmountErrorForDebit() throws InvalidAmountError, MinimumBalanceError {
        account.debit(-10000.00,"Madhuri");
    }

    @Test(expected = MinimumBalanceError.class)
    public void shouldReturnMinimumAmountError() throws InvalidAmountError, MinimumBalanceError {
        account.debit(1100,"Madhuri");
    }

    @Test
    public void shouldReturnDetailsAboutAccount(){
        assertEquals(account.getSummary(),"Name: Madhuri\nAccount Number: 1234-1234\nBalance: 1000.0");
    }

    @Test(expected = InvalidAccountNumberError.class)
    public void accountNumberShouldNotContainAlphabets() throws InvalidAccountNumberError, InvalidAmountException {
        Balance balance = getBalance(1000.00);
        account = new Account("Madhuri",new AccountNumber("12a4-1234"),balance);
    }

    @Test
    public void shouldContainCreditTransaction() throws InvalidAmountError {
        account.credit(1000.00,"Madhuri");
        assertThat(account.getAllTransactions(),hasItem(new CreditTransaction(1000.00,"Madhuri")));
    }
}
