package com.porto.financial.portopar.portoinvestments.exception;

import javax.ws.rs.core.Response;

/**
 * General exception to investments.
 * @author mangani
 */
public class PortoSeguroException extends RuntimeException {

	private static final long serialVersionUID = 8083804442259592941L;
	
	private Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;

	public PortoSeguroException(String message, Throwable cause) {
		super(message, cause);
	}

	public PortoSeguroException(String message) {
		super(message);
	}
	
	public PortoSeguroException withHttpStatus(Response.Status httpStatus) {
		
		this.httpStatus = httpStatus;
		
		return this;
	}
	
	public Response.Status getHttpStatus() {
		return this.httpStatus;
	}
}