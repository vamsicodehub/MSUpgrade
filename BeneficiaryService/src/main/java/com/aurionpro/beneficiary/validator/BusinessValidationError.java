/*
 * 
 */
package com.aurionpro.beneficiary.validator;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessValidationError.
 */
public class BusinessValidationError implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4941860681861695273L;

	/** The message key. */
	private String messageKey;
	
	/** The message values. */
	private List<String> messageValues;

	/**
	 * Gets the message key.
	 *
	 * @return the message key
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * Sets the message key.
	 *
	 * @param messageKey the new message key
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Gets the message values.
	 *
	 * @return the message values
	 */
	public List<String> getMessageValues() {
		return messageValues;
	}

	/**
	 * Sets the message values.
	 *
	 * @param messageValues the new message values
	 */
	public void setMessageValues(List<String> messageValues) {
		this.messageValues = messageValues;
	}
	
	
}
