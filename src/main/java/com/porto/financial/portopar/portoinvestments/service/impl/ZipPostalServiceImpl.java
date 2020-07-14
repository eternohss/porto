package com.porto.financial.portopar.portoinvestments.service.impl;

import static com.porto.financial.portopar.portoinvestments.types.ErrorMessage.ERROR_OPERATION;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.porto.financial.portopar.portoinvestments.exception.PortoSeguroException;
import com.porto.financial.portopar.portoinvestments.response.AddressResponse;
import com.porto.financial.portopar.portoinvestments.rest.client.RestClient;
import com.porto.financial.portopar.portoinvestments.service.ZipPostalService;

import static com.porto.financial.portopar.portoinvestments.types.Endpoints.VIA_CEP;

/**
 * Default implementation of {@link ZipPostalService}.
 * @author mangani
  */
@ApplicationScoped
public class ZipPostalServiceImpl implements ZipPostalService {
	
	@Inject
	private RestClient restClient;

	/**
	 * {@inheritDoc}
	 */
	public AddressResponse find(String zipCode) {
		
		try {
			return this.restClient
					.getClient()
					.target(VIA_CEP.location(zipCode))
					.request(MediaType.APPLICATION_JSON)
					.get(AddressResponse.class);
			
		} catch (Exception e) {
			throw new PortoSeguroException(ERROR_OPERATION.error(), e).withHttpStatus(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}