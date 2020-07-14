package com.porto.financial.portopar.portoinvestments.service;

import java.util.List;

import com.porto.financial.portopar.portoinvestments.response.SelicResponse;

/**
 * Default contract to selic rate services.
 * @author mangani
 */
public interface SelicService {
	
	/**
	 * List all computed selic rate from Brazilian Central Bank.
	 * @param initialDate - Initial date.
	 * @param finalDate - Final date.
	 * @return - List of rates according date.
	 */
	public List<SelicResponse> list(String initialDate, String finalDate);
}