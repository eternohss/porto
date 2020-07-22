package com.porto.financial.portopar.portoinvestments.bo;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;

@ApplicationScoped
public class CalculateInvestmentsBo {

    /**
     * Calculate future value
     *
     * @param monthlyAmount
     * @param periods
     * @param rate
     * @return
     */
    public BigDecimal getFutureValue(BigDecimal monthlyAmount, Integer periods, BigDecimal rate, BigDecimal initialAmount) {

        monthlyAmount = monthlyAmount.setScale(2, RoundingMode.HALF_UP);

        rate = rate.divide(BigDecimal.valueOf(100));

        BigDecimal ex = BigDecimal.ONE;

        BigDecimal cont = BigDecimal.ONE;

        for (int i = 1; i <= periods; i++) {
            cont = cont.multiply(rate.add(BigDecimal.ONE));
            ex = ex.add(cont);
        }

        BigDecimal rounded = ex.subtract(cont);

        BigDecimal monthlyAmountFactor = monthlyAmount.multiply(cont);

        BigDecimal futureValue = monthlyAmountFactor.divide(rounded, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(periods));

        BigDecimal finalCont = cont;

        return Optional.ofNullable(initialAmount).
                map(initialAmountValue -> futureValue.add(initialAmountValue.multiply(finalCont)))
                .orElse(futureValue).setScale(2, RoundingMode.HALF_UP);

    }
}
