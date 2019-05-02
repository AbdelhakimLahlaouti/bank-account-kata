package account;

import entities.Account;
import entities.Operation;
import enumeration.OperationTypeEnum;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShouldGetOperationsBetweenTest {

    private static final LocalDate FROM_DATE = LocalDate.of(2019,Month.APRIL,1);
    private static final LocalDate TO_DATE = LocalDate.of(2019,Month.JULY,30);
    private Account account;

    @Before
    public void setUp() {
        //given
        account = new Account(BigDecimal.valueOf(1000),300);
        account.deposit(BigDecimal.valueOf(500));
        account.deposit(BigDecimal.valueOf(78.56));
        account.withdraw(BigDecimal.valueOf(180));
        account.deposit(BigDecimal.valueOf(500));
        account.deposit(BigDecimal.valueOf(20));
        account.getOperations().get(0).setDateTime(LocalDateTime.of(2019, Month.APRIL, 1, 10, 10, 30));
        account.getOperations().get(1).setDateTime(LocalDateTime.of(2019, Month.MAY, 5, 10, 10, 30));
        account.getOperations().get(2).setDateTime(LocalDateTime.of(2019, Month.JUNE, 23, 10, 10, 30));
        account.getOperations().get(3).setDateTime(LocalDateTime.of(2019, Month.JULY, 30, 10, 10, 30));
        account.getOperations().get(4).setDateTime(LocalDateTime.of(2019, Month.AUGUST, 9, 10, 10, 30));
    }

    @Test
    public void shouldGetTransactionsBetweenTwoDates() {

        //when
        List<Operation> operationsBetween = account.getOperationsBetween(FROM_DATE ,TO_DATE);

        assertEquals(3,operationsBetween.size());
        assertEquals(LocalDateTime.of(2019,Month.APRIL,1,10,10,30),operationsBetween.get(0).getDateTime());
        assertEquals(BigDecimal.valueOf(180),operationsBetween.get(2).getAmount());
        assertEquals(OperationTypeEnum.DEPOSIT,operationsBetween.get(1).getOperationType());

    }

}
