import com.thoughtworks.bank.Account;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("1234", 100.00);
    }

    @Test
    public void checkBalance() {
        assertEquals(account.getBalance(), 100.00);
    }

    @Test
    public void addAmount(){
        account.credit(10000.00);
        assertEquals(account.getBalance(),10100.00);
    }

}
