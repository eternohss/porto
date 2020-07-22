package com.porto.financial.portopar.portoinvestments.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Defines a model payload to CalculateInvestments object.
 * @author mangani.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class CalculateInvestmentsRequest {

    @JsonProperty("aporte-inicial")
    private BigDecimal initialContribution;

    @JsonProperty("aporte-mensal")
    private BigDecimal monthlyContribution;

    @JsonProperty("periodo-investimento")
    private Integer investmentPeriod;

    public BigDecimal getInitialContribution() {
        return initialContribution;
    }

    public void setInitialContribution(BigDecimal initialContribution) {
        this.initialContribution = initialContribution;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(BigDecimal monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    public Integer getInvestmentPeriod() {
        return investmentPeriod;
    }

    public void setInvestmentPeriod(Integer investmentPeriod) {
        this.investmentPeriod = investmentPeriod;
    }
}
