package operation;

import entities.Account;
import entities.WithdrawOperation;
import enumeration.OperationTypeEnum;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WithdrawOperationTest {

    private Account account;
    @Before
    public void setUp() throws Exception {
        //given
        account = new Account(BigDecimal.valueOf(1000),300);
    }

    @Test
    public void ShouldCreateWithdrawOperation() {
        //when
        account.getOperations().add(new WithdrawOperation(BigDecimal.valueOf(250),account.getBalance()));

        //then
        assertEquals(1, account.getOperations().size());
        assertEquals(OperationTypeEnum.WITHDRAWAL, account.getOperations().get(0).getOperationType());
        assertEquals(BigDecimal.valueOf(250),account.getOperations().get(0).getAmount());
        assertEquals(BigDecimal.valueOf(750),account.getOperations().get(0).getNewBalance());
    }
}