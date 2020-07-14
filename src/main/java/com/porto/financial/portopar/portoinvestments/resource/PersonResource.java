package com.porto.financial.portopar.portoinvestments.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.porto.financial.portopar.portoinvestments.request.PersonRequest;
import com.porto.financial.portopar.portoinvestments.service.PersonService;

@Path("/persons")
public class PersonResource {
	
	@Inject
	private PersonService personService;
		
	@POST
	@Path("/welcome")
	public Response welcome(PersonRequest person) {
		return Response.ok(personService.greeting(person)).build();
	}
}