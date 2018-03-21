import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InvalidAccountNumberError;
import com.thoughtworks.bank.InvalidAmountError;
import com.thoughtworks.bank.MinimumBalanceError;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws InvalidAccountNumberError {
        account = new Account("1234-1234", 1000.00);
    }

    @Test
    public void shouldReturnAvailableBalance() {
        assertEquals(account.getBalance(),1000.00);
    }

    @Test
    public void shouldAddGivenAmountToAccount() throws InvalidAmountError {
        account.credit(10000.00);
        assertEquals(account.getBalance(),11000.00);
    }

    @Test
    public void shouldWithdrawAmount() throws InvalidAmountError, MinimumBalanceError {
        account.credit(10000.00);
        account.debit(5000.00);
        assertEquals(account.getBalance(),6000,0);
    }

    @Test(expected = InvalidAmountError.class)
    public void shouldReturnInvalidAmountErrorForCredit() throws InvalidAmountError {
        account.credit(-10000.00);
    }

    @Test(expected = InvalidAmountError.class)
    public void shouldReturnInvalidAmountErrorForDebit() throws InvalidAmountError, MinimumBalanceError {
        account.debit(-10000.00);
    }

    @Test(expected = MinimumBalanceError.class)
    public void shouldReturnMinimumAmountError() throws InvalidAmountError, MinimumBalanceError {
        account.debit(1100);
    }

    @Test(expected = InvalidAccountNumberError.class)
    public void shouldCheckAccountNumber() throws InvalidAccountNumberError {
        account = new Account("123-1234", 1000.00);
    }
}
