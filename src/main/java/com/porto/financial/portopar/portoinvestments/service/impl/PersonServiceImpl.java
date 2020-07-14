package com.porto.financial.portopar.portoinvestments.service.impl;

import static com.porto.financial.portopar.portoinvestments.types.InfoMessage.WELCOME;

import javax.enterprise.context.ApplicationScoped;

import com.porto.financial.portopar.portoinvestments.request.PersonRequest;
import com.porto.financial.portopar.portoinvestments.response.GreetingResponse;
import com.porto.financial.portopar.portoinvestments.service.PersonService;


/**
 * Default implementation of Person services.
 * @author mangani
 */
@ApplicationScoped
public class PersonServiceImpl implements PersonService {

	/**
	 * {@inheritDoc}
	 */
	public GreetingResponse greeting(PersonRequest person) {
		
		GreetingResponse response = new GreetingResponse();
		response.setWelcome(WELCOME.message(person.getName()));
		
		return response;
	}
}