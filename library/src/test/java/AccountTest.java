import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.invalidAmountError;
import com.thoughtworks.bank.minimumBalanceError;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("1234", 1000.00);
    }

    @Test
    public void checkBalance() {
        assertEquals(account.getBalance(), 1000.00);
    }

    @Test
    public void addAmount() throws invalidAmountError {
        account.credit(10000.00);
        assertEquals(account.getBalance(),11000.00);
    }

    @Test
    public void withdrawAmount() throws invalidAmountError, minimumBalanceError {
        account.credit(10000.00);
        account.debit(5000.00);
        assertEquals(account.getBalance(),6000,0);
    }
}
