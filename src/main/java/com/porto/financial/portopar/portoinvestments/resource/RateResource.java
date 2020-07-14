package com.porto.financial.portopar.portoinvestments.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.porto.financial.portopar.portoinvestments.response.SelicResponse;
import com.porto.financial.portopar.portoinvestments.service.SelicService;

/**
 * Resource to get selic interest rate.
 * @author mangani
 */
@Path("/rates")
public class RateResource {
	
	@Inject
	private SelicService selicService;
	
	/**
	 * To get a selic rate.
	 * @param initialDate - Initial date.
	 * @param finalDate - Final date.
	 * @return - List of {@link SelicResponse}.
	 */
	@GET
	@Path("/selic")
	public Response selic(
			@QueryParam("initial-date") String initialDate, 
			@QueryParam("final-date") String finalDate) {
		
		List<SelicResponse> rates = this.selicService.list(initialDate, finalDate); 
		
		return Response.ok(new GenericEntity<List<SelicResponse>>(rates){}).build();
	}
}