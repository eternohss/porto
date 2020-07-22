package com.porto.financial.portopar.portoinvestments.response;

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
public class CalculateInvestmentsResponse {

    @JsonProperty("aporte-inicial")
    private BigDecimal initialContribution;

    @JsonProperty("valor-futuro")
    private BigDecimal valueFuture;

    @JsonProperty("qtd-meses")
    private Integer numberMonths;

    public BigDecimal getInitialContribution() {
        return initialContribution;
    }

    public void setInitialContribution(BigDecimal initialContribution) {
        this.initialContribution = initialContribution;
    }

    public BigDecimal getValueFuture() {
        return valueFuture;
    }

    public void setValueFuture(BigDecimal valueFuture) {
        this.valueFuture = valueFuture;
    }

    public Integer getNumberMonths() {
        return numberMonths;
    }

    public void setNumberMonths(Integer numberMonths) {
        this.numberMonths = numberMonths;
    }
}
