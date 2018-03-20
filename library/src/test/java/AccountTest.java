import com.thoughtworks.bank.Account;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AccountTest {
    @Test
    public void checkBalance() {
        Account account = new Account("1234", 100.00);
        assertEquals(account.getBalance(), 100.00);
    }

}
