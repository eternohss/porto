package com.porto.financial.portopar.portoinvestments.types;

/**
 * Defines utilized http protocols.
 * @author mangani
 */
public enum HttpProtocol {
	
	SSL("SSL"),
	SSL_TLS("SSL_TLS"),
	TLS_V1_2("TLSv1.2");
	
	private final String protocol;

	private HttpProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String protocol() {
		return protocol;
	}
}
