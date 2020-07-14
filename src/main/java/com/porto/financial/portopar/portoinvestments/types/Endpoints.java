package com.porto.financial.portopar.portoinvestments.types;

import java.text.MessageFormat;

/**
 * Define some commons URIs.
 * @author mangani
 *
 */
public enum Endpoints {

	GREETING_URI("http://localhost:8080/porto-investments/api/persons/welcome"),
	VIA_CEP("https://viacep.com.br/ws/{0}/json"),
	SELIC_URL("https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json&dataInicial={0}&dataFinal={1}");
	
	private final String location;

	private Endpoints(String location) {
		this.location = location;
	}
	
	public String location() {
		return this.location;
	}
	
	public String location(Object ... params) {
		return MessageFormat.format(this.location, params);
	}
}