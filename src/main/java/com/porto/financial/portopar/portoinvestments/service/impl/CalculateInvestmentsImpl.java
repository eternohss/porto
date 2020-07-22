package com.porto.financial.portopar.portoinvestments.service.impl;

import com.porto.financial.portopar.portoinvestments.bo.CalculateInvestmentsBo;
import com.porto.financial.portopar.portoinvestments.exception.PortoSeguroException;
import com.porto.financial.portopar.portoinvestments.request.CalculateInvestmentsRequest;
import com.porto.financial.portopar.portoinvestments.response.BcRateResponse;
import com.porto.financial.portopar.portoinvestments.response.CalculateInvestmentsResponse;
import com.porto.financial.portopar.portoinvestments.rest.client.RestClient;
import com.porto.financial.portopar.portoinvestments.service.CalculateInvestments;
import org.apache.commons.collections.CollectionUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.porto.financial.portopar.portoinvestments.types.Endpoints.SELIC_URL;
import static com.porto.financial.portopar.portoinvestments.types.ErrorMessage.ERROR_OPERATION;
import static com.porto.financial.portopar.portoinvestments.types.ErrorMessage.ERROR_OPERATION_BC;

/**
 * Default implementation of CalculateInvestments services.
 *
 * @author hilde
 */
@ApplicationScoped
public class CalculateInvestmentsImpl implements CalculateInvestments {

    @Inject
    private CalculateInvestmentsBo calculateInvestmentsBo;

    @Inject
    private RestClient restClient;

    /**
     * This service calculates the future value
     *
     * @param calculateInvestmentsRequest {@link CalculateInvestmentsRequest}.
     * @return {@link CalculateInvestmentsResponse}.
     */
    @Override
    public CalculateInvestmentsResponse getValueFuture(CalculateInvestmentsRequest calculateInvestmentsRequest){

        try {

            LocalDate now = LocalDate.now();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate localDateInvestmentPeriod = now.plusMonths(calculateInvestmentsRequest.getInvestmentPeriod());

            List<BcRateResponse> bcRateResponses = this.restClient
                    .getClient()
                    .target(SELIC_URL.location(now.format(dtf), localDateInvestmentPeriod.format(dtf)))
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<BcRateResponse>>(){});

            if (CollectionUtils.isEmpty(bcRateResponses)) {
                throw new PortoSeguroException(ERROR_OPERATION_BC.error()).withHttpStatus(Response.Status.BAD_REQUEST);
            }

            BigDecimal futureValue = this.calculateInvestmentsBo.
                    getFutureValue(calculateInvestmentsRequest.getMonthlyContribution(),
                            calculateInvestmentsRequest.getInvestmentPeriod(), bcRateResponses.get(0).getRate(), calculateInvestmentsRequest.getInitialContribution());

            CalculateInvestmentsResponse calculateInvestmentsResponse = new CalculateInvestmentsResponse();

            calculateInvestmentsResponse.setValueFuture(futureValue);

            calculateInvestmentsResponse.setInitialContribution(calculateInvestmentsRequest.getInitialContribution());

            calculateInvestmentsResponse.setNumberMonths(calculateInvestmentsRequest.getInvestmentPeriod());

            return calculateInvestmentsResponse;

        } catch (Exception e) {
            throw new PortoSeguroException(ERROR_OPERATION.error(), e).withHttpStatus(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }
}
