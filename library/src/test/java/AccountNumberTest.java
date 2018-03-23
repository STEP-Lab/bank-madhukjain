import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberError;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberError.class)
    public void shouldCheckAccountNumber() throws InvalidAccountNumberError {
        AccountNumber accountNumber = new AccountNumber("124-1234");
    }
    @Test
    public void shouldReturnAccountNumber() throws InvalidAccountNumberError {
        AccountNumber accountNumber = new AccountNumber("1243-1234");
        assertThat(accountNumber.getAccountNumber(),is("1243-1234"));

    }
}
