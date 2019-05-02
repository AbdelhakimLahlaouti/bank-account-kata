package utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MonetaryFormatTest {

    @Test
    public void getMonetaryFormat() {
        //given
        BigDecimal amount = new BigDecimal("123.4576938");

        //when
        amount = MonetaryFormat.getMonetaryFormat(amount);

        //then
        assertEquals(new BigDecimal("123.46"),amount);
    }
}