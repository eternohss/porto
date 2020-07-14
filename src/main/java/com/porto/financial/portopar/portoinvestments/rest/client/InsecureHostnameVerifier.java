package com.porto.financial.portopar.portoinvestments.rest.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * It does not necessary to create viewer to check hostname at this moment. 
 * @author mangani
  */
public class InsecureHostnameVerifier implements HostnameVerifier {

	public boolean verify(String arg0, SSLSession arg1) {
		return true;
	}
}
