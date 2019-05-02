package account;

import entities.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShouldBeCreditedTest {

    private Account account;
    @Before
    public void setUp() {
        //given
        account = new Account();
    }

    @Test
    public void shouldDeposit500() {
        //when
        account.deposit(BigDecimal.valueOf(500));

        //then
        assertEquals(BigDecimal.valueOf(500),account.getBalance());
    }

    @Test
    public void shouldDepositMultiplesTimes() {
        //when
        account.deposit(BigDecimal.valueOf(300));
        account.deposit(BigDecimal.valueOf(78.56));

        //then
        assertEquals(BigDecimal.valueOf(378.56),account.getBalance());
    }
}
