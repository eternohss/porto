package com.porto.financial.portopar.portoinvestments;

import com.porto.financial.portopar.portoinvestments.bo.CalculateInvestmentsBo;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculateInvestmentsBoTest {

    private CalculateInvestmentsBo calculateInvestmentsBo;

    @Test
    public void testGetFutureValue_when_initialAmount_is_null() {
        calculateInvestmentsBo = new CalculateInvestmentsBo();
        BigDecimal futureValue = calculateInvestmentsBo.getFutureValue(BigDecimal.valueOf(100), 12, BigDecimal.valueOf(0.008442), null);
        assertEquals(BigDecimal.valueOf(100.05), futureValue);

    }

    @Test
    public void testGetFutureValue_when_initialAmount_is_not_null() {
        calculateInvestmentsBo = new CalculateInvestmentsBo();
        BigDecimal futureValue = calculateInvestmentsBo.getFutureValue(BigDecimal.valueOf(100), 12, BigDecimal.valueOf(0.008442), BigDecimal.valueOf(10.00));
        assertEquals(BigDecimal.valueOf(110.07), futureValue);

    }
}
