package com.porto.financial.portopar.portoinvestments.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.porto.financial.portopar.portoinvestments.response.SelicResponse;
import com.porto.financial.portopar.portoinvestments.rest.client.RestClient;
import com.porto.financial.portopar.portoinvestments.service.SelicService;
import com.porto.financial.portopar.portoinvestments.types.Endpoints;

/**
 * Default {@link SelicService} implementation.
 * @author mangani
 */
public class SelicServiceImpl implements SelicService {
	
	@Inject
	private RestClient restClient;

	/**
	 * {@inheritDoc}
	 */
	public List<SelicResponse> list(String initialDate, String finalDate) {
		
		List<SelicResponse> selics = this.restClient
				.getClient()
				.target(Endpoints.SELIC_URL.location(initialDate, finalDate))
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<SelicResponse>>(){});
		
		return selics;
	}
}