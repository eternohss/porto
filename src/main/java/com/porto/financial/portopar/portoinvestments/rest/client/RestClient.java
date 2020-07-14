package com.porto.financial.portopar.portoinvestments.rest.client;

import static com.porto.financial.portopar.portoinvestments.types.ErrorMessage.ERROR_CREATE_HTTP_CLIENT;
import static com.porto.financial.portopar.portoinvestments.types.HttpProtocol.SSL;

import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.porto.financial.portopar.portoinvestments.exception.PortoSeguroException;

/**
 * Represents a client to connect with rest resources.
 * @author mangani
 */
@ApplicationScoped
public class RestClient {
	
	private Client client;
	
	/**
	 * Initialize client.
	 */
	@PostConstruct
	private void init() {
		
		try {
			SSLContext ssl = SSLContext.getInstance(SSL.protocol());
			ssl.init(null, new InsecureTrustManager[]{new InsecureTrustManager()}, new SecureRandom());
			
			this.client = ClientBuilder
					.newBuilder()
					.register(JacksonJsonProvider.class)
					.sslContext(ssl)
					.hostnameVerifier(new InsecureHostnameVerifier())
					.build();
			
		} catch (Exception e) {
			throw new PortoSeguroException(ERROR_CREATE_HTTP_CLIENT.error());
		}
	}
	
	public synchronized Client getClient() {
		return this.client;
	}
}