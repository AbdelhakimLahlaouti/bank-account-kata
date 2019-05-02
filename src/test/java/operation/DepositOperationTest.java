package operation;

import entities.Account;
import entities.DepositOperation;
import enumeration.OperationTypeEnum;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DepositOperationTest {

    private Account account;
    @Before
    public void setUp() throws Exception {
        //given
        account = new Account(BigDecimal.valueOf(1000),300);
    }

    @Test
    public void ShouldCreateDepositOperation() {
        //when
        account.getOperations().add(new DepositOperation(BigDecimal.valueOf(500),account.getBalance()));

        //then
        assertEquals(1, account.getOperations().size());
        assertEquals(OperationTypeEnum.DEPOSIT, account.getOperations().get(0).getOperationType());
        assertEquals(BigDecimal.valueOf(500),account.getOperations().get(0).getAmount());
        assertEquals(BigDecimal.valueOf(1500),account.getOperations().get(0).getNewBalance());
    }
}