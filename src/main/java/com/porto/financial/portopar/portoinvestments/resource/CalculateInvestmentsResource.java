package com.porto.financial.portopar.portoinvestments.resource;

import com.porto.financial.portopar.portoinvestments.request.CalculateInvestmentsRequest;
import com.porto.financial.portopar.portoinvestments.service.CalculateInvestments;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/investments")
public class CalculateInvestmentsResource {

    @Inject
    private CalculateInvestments calculateInvestments;

    @GET
    @Path("/value-future")
    public Response getVAlueFuture(CalculateInvestmentsRequest calculateInvestmentsRequest){

        return Response.ok(this.calculateInvestments.getValueFuture(calculateInvestmentsRequest)).build();
    }
}
