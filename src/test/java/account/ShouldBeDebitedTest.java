package account;

import entities.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ShouldBeDebitedTest {

    private Account account;
    @Before
    public void setUp() {
        //given
        account = new Account(BigDecimal.valueOf(1000),300);
    }

    @Test
    public void shouldWithdraw400(){
        //when
        account.withdraw(BigDecimal.valueOf(400));

        //then
        assertEquals(BigDecimal.valueOf(600),account.getBalance());

    }@Test
    public void shouldWithdraw1250WhenBalanceIs1000AndOverdraft300(){
        //when
        account.withdraw(BigDecimal.valueOf(1250));

        //then
        assertEquals(BigDecimal.valueOf(-250),account.getBalance());

    }

    @Test
    public void shouldWithDrawMultiplesTimes() {
        //when
        account.withdraw(BigDecimal.valueOf(180));
        account.withdraw(BigDecimal.valueOf(23));

        //then
        assertEquals(BigDecimal.valueOf(797),account.getBalance());
    }
}
