package com.porto.financial.portopar.portoinvestments.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.porto.financial.portopar.portoinvestments.service.ZipPostalService;

/**
 * Represents an end-point to search Brazilian ZipPostal. 
 * @author mangani
 */
@Path("/zip-postal")
public class ZipPostalResource {
	
	@Inject
	private ZipPostalService zipPostalService;
	
	@GET
	@Path("/{zip-code}")
	public Response find (@PathParam("zip-code") String zipCode) {
		return Response.ok(this.zipPostalService.find(zipCode)).build();
	}
}