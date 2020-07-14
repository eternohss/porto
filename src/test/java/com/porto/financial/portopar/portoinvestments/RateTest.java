package com.porto.financial.portopar.portoinvestments;

import org.junit.Test;

import java.math.BigDecimal;

public class RateTest {

  @Test(expected = Exception.class)
  public void divideByZero() {
    BigDecimal.TEN.divide(BigDecimal.ZERO);
  }
}