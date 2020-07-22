package com.porto.financial.portopar.portoinvestments.service;

import com.porto.financial.portopar.portoinvestments.request.CalculateInvestmentsRequest;
import com.porto.financial.portopar.portoinvestments.response.CalculateInvestmentsResponse;

/**
 * Defines a service layer to CalculateInvestments
 * @author Hilde
 */
public interface CalculateInvestments {

    /**
     * This service calculates the future value
     *
     * @param calculateInvestmentsRequest {@link CalculateInvestmentsRequest}.
     * @return  {@link CalculateInvestmentsResponse}.
     */
    public CalculateInvestmentsResponse getValueFuture(CalculateInvestmentsRequest calculateInvestmentsRequest);
}
