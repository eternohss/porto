package com.porto.financial.portopar.portoinvestments.types;

/**
 * Definition of error messages.
 * @author mangani
 */
public enum ErrorMessage {
	
	INVALID_NAME("Invalid name"),
	ERROR_CREATE_HTTP_CLIENT("Something went wrong when trying to create a rest client"),
	ERROR_OPERATION("Something went wrong when trying to make this operation");
	
	private final String error;

	private ErrorMessage(String error) {
		this.error = error;
	}

	public String error() {
		return error;
	}
}
