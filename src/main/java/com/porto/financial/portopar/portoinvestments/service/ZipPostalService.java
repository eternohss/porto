package com.porto.financial.portopar.portoinvestments.service;

import com.porto.financial.portopar.portoinvestments.response.AddressResponse;

/**
 * Integration service to Brazilian zip postal.
 * @author mangani
 */
public interface ZipPostalService {
	
	/**
	 * Tries to get Adress info from Brazil Zip Code.
	 * @param zipCode - Zip code.
	 * @return - {@link AddressResponse}.
	 */
	AddressResponse find(String zipCode);
}
