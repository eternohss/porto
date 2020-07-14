package com.porto.financial.portopar.portoinvestments.types;

import java.text.MessageFormat;

/**
 * Definition of info messages.
 * @author mangani
 */
public enum InfoMessage {
	
	WELCOME("Welcome {0}.");
	
	private final String value;

	private InfoMessage(String value) {
		this.value = value;
	}

	public String message(Object ... args) {
		return MessageFormat.format(this.value, args);
	}
}