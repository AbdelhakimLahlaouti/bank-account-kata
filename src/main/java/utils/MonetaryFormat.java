package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

//for the display on the front end
public class MonetaryFormat {
    private MonetaryFormat() {

    }

    public static BigDecimal getMonetaryFormat (BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_EVEN);
    }
}
