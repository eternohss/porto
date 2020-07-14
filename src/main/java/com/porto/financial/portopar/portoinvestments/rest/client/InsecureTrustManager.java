package com.porto.financial.portopar.portoinvestments.rest.client;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * It does not necessary to create a trust manager with a certification.
 * @author mangani.
 */
public class InsecureTrustManager implements X509TrustManager {
  
  public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
  }

  
  public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
  }

  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }
}
