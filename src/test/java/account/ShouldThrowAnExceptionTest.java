package account;

import entities.Account;
import exception.InvalidAmountException;
import exception.NotEnoughBalanceException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ShouldThrowAnExceptionTest {

    private Account account;
    @Before
    public void setUp() {
        //given
        account = new Account(BigDecimal.valueOf(1000),300);
    }

    @Test(expected = InvalidAmountException.class)
    public void shouldGetInvalidAmountExceptionInDepositWhenAmountIsZero() {
        //when
        account.deposit(BigDecimal.ZERO);
    }

    @Test (expected = InvalidAmountException.class)
    public void shouldGetInvalidAmountExceptionInDepositWhenAmountIsNegative() {
        //when
        account.withdraw(BigDecimal.valueOf(-125));
    }

    @Test(expected = NotEnoughBalanceException.class)
    public void ShouldNotBeAbleToWithdrawWhenThresholdExceeded() {
        //when
        account.withdraw(BigDecimal.valueOf(1500));
    }
}
