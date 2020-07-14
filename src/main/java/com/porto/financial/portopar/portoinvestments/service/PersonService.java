package com.porto.financial.portopar.portoinvestments.service;

import com.porto.financial.portopar.portoinvestments.request.PersonRequest;
import com.porto.financial.portopar.portoinvestments.response.GreetingResponse;

/**
 * Defines a service layer to person business.
 * @author mangani
  */
public interface PersonService {
	
	/**
	 * This operation makes a greeting to a new person.
	 * @param person - {@link PersonRequest}.
	 * @return - {@link GreetingResponse}.
	 */
	public GreetingResponse greeting(PersonRequest person);
}